class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        Arrays.fill(result, -1);
        
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;
            int currentNum = nums[currentIndex];

            while (!stack.isEmpty() && nums[stack.peek()] < currentNum) {
                int poppedIndex = stack.pop();
                result[poppedIndex] = currentNum;
            }

            if (i < n) {
                stack.push(currentIndex);
            }
        }

        return result;
    }
}