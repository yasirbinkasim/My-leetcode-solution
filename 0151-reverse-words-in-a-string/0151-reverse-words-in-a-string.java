class Solution {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length()-1;

        while(i>=0){
            while(i>=0 && s.charAt(i) == ' '){
                i--;
            }
            if(i < 0){
                break;
            }

            int right = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, right + 1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}