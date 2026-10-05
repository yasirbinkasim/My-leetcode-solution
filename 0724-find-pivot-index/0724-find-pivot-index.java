class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++){
            totalSum = totalSum + nums[i];
        }
        for(int i = 0; i < n; i++){
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum){
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}