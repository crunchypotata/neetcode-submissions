class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Build a frequency map
        Map<Integer, Integer> counters = new HashMap<>();

        for (int number : nums) {
            counters.put(number, counters.getOrDefault(number, 0) + 1);
        }
        
        // 2. Create a Min-Heap (Ascending order based on frequency)
        // Elements with the lowest frequency will stay at the top
        PriorityQueue<Integer>  minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(counters.get(a), counters.get(b))
        );
        
        // 3. Insert all unique numbers from the map into the heap.
        // This triggers the internal sorting (heapify) mechanism.
        for (int number: counters.keySet()) {
            minHeap.add(number);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 4. Extract the top K most frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll(); // .poll() removes and returns the highest priority (maximum) element
        }

        return result;
    }
}