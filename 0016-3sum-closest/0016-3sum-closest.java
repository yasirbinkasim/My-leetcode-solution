class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i< nums.length - 2; i++){

            int j = i+1;
            int k = nums.length-1;

            while (j < k){
                int currentSum = nums[i] + nums[j] + nums[k];

                
                if (currentSum == target){
                    return currentSum;
                }
                long currentDiff = Math.abs((long)target - currentSum);
                long closestDiff = Math.abs((long)target - closestSum);

                if (currentDiff < closestDiff) {
                    closestSum = currentSum;
                }
                if(currentSum<target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return closestSum;
    }
}