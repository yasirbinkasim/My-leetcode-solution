class Solution {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        if(n < 3){
            return 0;
        }
        int count = 0;
        for(int i = 0; i <= n-3; i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            char ch3 = s.charAt(i+2);

            if(ch1!=ch2 && ch1!=ch3 && ch2!=ch3){
                count++;
            }
        }
        return count;
    }
}