class Solution {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int count = 0;
        int n = str.length();

        for (int i = 0; i <= n-k; i++){
            String subStr = str.substring(i, i+k);

            int val = Integer.parseInt(subStr);

            if(val == 0){
                continue;
            }

            if(num%val == 0){
                count++;
            }
        }
        return count;
    }
}