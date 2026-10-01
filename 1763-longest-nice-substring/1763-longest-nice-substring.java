class Solution {
    public String longestNiceSubstring(String s) {
        String result = "";
        for (int u = 1; u <= 26; u++) {
            int[] lower = new int[26];
            int[] upper = new int[26];
            
            int left = 0, uniqueCount = 0, niceCount = 0;
            for (int right = 0; right < s.length(); right++) {
                char rChar = s.charAt(right);
                if (Character.isLowerCase(rChar)) {
                    int idx = rChar - 'a';
                    if (lower[idx] == 0 && upper[idx] == 0) uniqueCount++;
                    lower[idx]++;
                    if (lower[idx] == 1 && upper[idx] >= 1) niceCount++;
                } else {
                    int idx = rChar - 'A';
                    if (lower[idx] == 0 && upper[idx] == 0) uniqueCount++;
                    upper[idx]++;
                    if (upper[idx] == 1 && lower[idx] >= 1) niceCount++;
                }
                while (uniqueCount > u) {
                    char lChar = s.charAt(left);
                    if (Character.isLowerCase(lChar)) {
                        int idx = lChar - 'a';
                        if (lower[idx] == 1 && upper[idx] >= 1) niceCount--;
                        lower[idx]--;
                        if (lower[idx] == 0 && upper[idx] == 0) uniqueCount--;
                    } else {
                        int idx = lChar - 'A';
                        if (upper[idx] == 1 && lower[idx] >= 1) niceCount--;
                        upper[idx]--;
                        if (lower[idx] == 0 && upper[idx] == 0) uniqueCount--;
                    }
                    left++;
                }
                if (uniqueCount == u && uniqueCount == niceCount) {
                    if (right - left + 1 > result.length()) {
                        result = s.substring(left, right + 1);
                    }
                }
            }
        }
        
        return result;
    }
}
