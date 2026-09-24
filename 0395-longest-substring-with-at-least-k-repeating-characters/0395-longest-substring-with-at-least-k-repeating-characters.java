class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        
        for (int u = 1; u <= 26; u++) {
            int[] count = new int[26]; 
            int left = 0, right = 0;
            int uniqueSymbols = 0;
            int symbolsWithAtLeastK = 0;

            while (right < s.length()) {
                
                if (uniqueSymbols <= u) {
                    int idx = s.charAt(right) - 'a';
                    if (count[idx] == 0) uniqueSymbols++; 
                    count[idx]++;
                    if (count[idx] == k) symbolsWithAtLeastK++;
                    right++;
                } 
                else {
                    int idx = s.charAt(left) - 'a';
                    if (count[idx] == k) symbolsWithAtLeastK--; 
                    count[idx]--;
                    if (count[idx] == 0) uniqueSymbols--; 
                    left++;
                }
                if (uniqueSymbols == u && uniqueSymbols == symbolsWithAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        
        return maxLen;
    }
}
