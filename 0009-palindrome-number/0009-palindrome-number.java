class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int originalNumber = x;
        int reversedNumber = 0;

        while (x > 0) {
            int remainder = x % 10;
            
            if (reversedNumber > (Integer.MAX_VALUE - remainder) / 10) {
                return false; 
            }

            reversedNumber = (reversedNumber * 10) + remainder; 
            x = x / 10;
        }

        return originalNumber == reversedNumber;
    }
}