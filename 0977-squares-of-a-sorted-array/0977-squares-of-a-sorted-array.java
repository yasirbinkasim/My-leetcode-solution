class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int p = n-1;

        int[] result = new int[n];

        while (i <= j){
            int leftSq = nums[i] * nums[i];
            int rightSq = nums[j] * nums[j];

            if(leftSq >= rightSq){
                result[p] = leftSq;
                i++;
            }
            else {
                result[p] = rightSq;
                j--;
            }
            p--;
        } 
        return result;
    }
}