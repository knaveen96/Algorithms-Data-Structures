class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        int carry = 0;
        
        for(int i = n - 1 ; i >= 0 ; i--) {
            int currDigit = digits[i];
            if(currDigit == 9) {
                carry = 1;
                digits[i] = 0;
            }
            else {
                digits[i]++;
                carry = 0;
                return digits;
            }
        }
        
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}

/*

[9,9,9] -> 1000
^

carry - 1

1000


*/