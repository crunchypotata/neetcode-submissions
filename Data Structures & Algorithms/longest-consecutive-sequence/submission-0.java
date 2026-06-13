class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int number: nums) {
            set.add(number);
        }

        int maxLength = 0;
        
        for (int num: set) {

            if(!set.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum+1)) {
                    currentNum++;
                    currentLength++; 
                }

                maxLength = Math.max(maxLength, currentLength); 
            }    
        }

        
        return maxLength; 

    }
}
