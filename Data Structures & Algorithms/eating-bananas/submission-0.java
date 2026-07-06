class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 0;

        //сколько сможет съесть бананов макс
        for(int pile: piles) {
            right = Math.max(pile, right);
        }

        int avSpeed;
        //это к по условию
        int minSpeed = right;

        while(left <= right) {
            avSpeed = left + (right - left) / 2;

            if (canEatAll(piles, h, avSpeed)) {
                minSpeed = avSpeed;
                right = avSpeed - 1;
            } else {
                left = avSpeed + 1;
            }
        }

        return minSpeed;
    }

    //успевает ли съесть с такой скоростью
    public boolean canEatAll(int[] piles, int h, int avSpeed) {
        long totalHours = 0; 
        for (int pile: piles) {
            totalHours += (pile + avSpeed - 1) / avSpeed;
        }
        
        return totalHours <= h;
    }
}
