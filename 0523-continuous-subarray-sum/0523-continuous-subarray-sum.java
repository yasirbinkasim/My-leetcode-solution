public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            int rem = currentSum % k;
            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                int prevIndex = map.get(rem);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {23, 2, 4, 6, 7};
        System.out.println("Output 1: " + sol.checkSubarraySum(nums1, 6));

        int[] nums2 = {23, 2, 6, 4, 7};
        System.out.println("Output 2: " + sol.checkSubarraySum(nums2, 6));
    }
}