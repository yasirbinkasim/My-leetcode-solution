import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                currSum += -1;
            }
            else {
                currSum += +1;
            }

            if (map.containsKey(currSum)) {
                int currLength = i - map.get(currSum);
                maxLen = Math.max(maxLen,currLength);
            } else {
                map.put(currSum, i);
            }
        }
        return maxLen;
    }
}