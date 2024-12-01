class Solution {
    public boolean isPalindrome(int x) {
        int temp = 0, xTemp = x;
        if(x < 0) {
            return false;
        }
        else {
            while(x > 0) {
                temp = (temp * 10) + x%10;
                x = x/10;
            }
            if(temp == xTemp) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
