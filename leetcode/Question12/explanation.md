# Explanation: Find the Index of the First Occurrence in a String

## Problem Statement
Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

### Constraints:
- `1 <= haystack.length, needle.length <= 10^4`
- Both `haystack` and `needle` consist of only lowercase English characters.

---

## Approach

We are tasked with finding the first occurrence of the string `needle` inside `haystack`. 

The solution can be efficiently implemented using the `indexOf` method in Java, which is available on the `String` class. The `indexOf` method returns the index of the first occurrence of the specified substring, or `-1` if the substring is not found.

### Key Observations
- The problem specifies finding the **first occurrence** of the substring. Hence, the `indexOf` method is perfect as it directly returns the index of the first occurrence.
- If the `needle` is not found, `indexOf` will return `-1`, which matches the required output.
- The solution works in linear time relative to the size of the `haystack`, making it an efficient approach.

### Time Complexity: \(O(n)\)
- The `indexOf` method scans through the `haystack` string to find the first occurrence of the `needle`. This operation takes linear time, where \(n\) is the length of the `haystack`.

### Space Complexity: \(O(1)\)
- We are not using any additional data structures or space proportional to the input, so the space complexity is constant.

---

## Code Implementation

```java
class Solution {
    public int strStr(String haystack, String needle) {
        // Use the StringBuilder's indexOf method to find the first occurrence of needle in haystack
        return new StringBuilder(haystack).indexOf(needle, 0);
    }
}
```

---

## Example Walkthrough

### Example 1:
- **Input**: `haystack = "sadbutsad"`, `needle = "sad"`
- **Steps**:
  1. Call `indexOf("sad", 0)` on `"sadbutsad"`.
  2. The substring `"sad"` is found at index `0`.
  3. Return `0`.
- **Output**: `0`

### Example 2:
- **Input**: `haystack = "leetcode"`, `needle = "leeto"`
- **Steps**:
  1. Call `indexOf("leeto", 0)` on `"leetcode"`.
  2. The substring `"leeto"` is not found.
  3. Return `-1`.
- **Output**: `-1`

---

## Summary

This solution leverages Java's built-in `indexOf` method to find the first occurrence of a substring in linear time. It is simple, efficient, and directly solves the problem with minimal code. The time complexity is \(O(n)\), and the space complexity is \(O(1)\), making it optimal for large inputs.

---
