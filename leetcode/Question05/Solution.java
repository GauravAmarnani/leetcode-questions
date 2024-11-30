class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() < 1)
            return 0;
        str = str.replaceAll("^\\s+", "");
        int i = 0;
        boolean isNegative = str.startsWith("-");
        boolean isPositive = str.startsWith("+");
        if (isNegative)
            i++;
        else if (isPositive)
            i++;
        double number = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            number = number * 10 + (str.charAt(i) - '0');
            i++;
        }
        number = isNegative ? -number : number;
        if (number < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (number > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) number;
    }
}
