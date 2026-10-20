class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canEatAll(int[] piles, int speed, int h) {
        long totalHours = 0;
        
        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed;
        }
        
        return totalHours <= h;
    }
}
