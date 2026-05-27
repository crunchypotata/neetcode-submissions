class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> subArray = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (subArray.containsKey(complement)) {
                return new int[] {subArray.get(complement), i};
            } else {
                subArray.put(nums[i], i);
            }
        }

    return new int[] {};
    
    }
}
