class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();

        for (int num : nums2){

            while (!st.isEmpty() && st.peek() < num){
                int smallValue = st.pop();
                mp.put(smallValue, num);
            }
            st.push(num);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = mp.getOrDefault(nums1[i], -1);
        }
        return ans;

    }
}