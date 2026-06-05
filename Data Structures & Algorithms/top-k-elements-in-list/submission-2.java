class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Count how many times each number appears
        Map<Integer, Integer> counters = new HashMap<>();

        for (int number : nums) {
            counters.put(number, counters.getOrDefault(number, 0) + 1);
        }
        
        // 2. Create a Min-Heap that stores arrays: [frequency, number]
        // Sorted by frequency (index 0) from lowest to highest
        PriorityQueue<int[]>  minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        
        // 3. Go through unique numbers using simple keySet()
        for (int number : counters.keySet()) {
            int frequency = counters.get(number);
            
            // Push a pair [frequency, number] into the heap
            minHeap.offer(new int[]{frequency, number});

            // Keep the heap size strictly <= K
            if (minHeap.size() > k) {
                minHeap.poll(); // removes the element with the lowest frequency
            }
        }

        // 4. Get the top K numbers from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[1]; // index 1 contains the actual number
        }

        return result;
    }
}