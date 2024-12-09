class Solution {
    public int strStr(String haystack, String needle) {
        return new StringBuilder(haystack).indexOf(needle, 0);
    }
}
