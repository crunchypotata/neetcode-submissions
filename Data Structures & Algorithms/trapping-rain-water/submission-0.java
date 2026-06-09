class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                int currentWater = leftMax - height[left];
                maxWater += currentWater;
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                int currentWater = rightMax - height[right];
                maxWater += currentWater;
                right--;
            }
        }
        return maxWater;
    }
}
