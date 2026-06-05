class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Build a frequency map
        Map<Integer, Integer> counters = new HashMap<>();

        for (int number : nums) {
            counters.put(number, counters.getOrDefault(number, 0) + 1);
        }
        
        // 2. Create a Max-Heap (PriorityQueue) configured to sort 
        // unique numbers in descending order based on their frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(counters.get(b), counters.get(a))
        );
        
        // 3. Insert all unique numbers from the map into the heap.
        // This triggers the internal sorting (heapify) mechanism.
        maxHeap.addAll(counters.keySet());

        // 4. Extract the top K most frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll(); // .poll() removes and returns the highest priority (maximum) element
        }

        return result;
    }
}