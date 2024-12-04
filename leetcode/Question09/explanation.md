# Explanation: Longest Common Prefix

## Problem Statement
Given an array of strings `strs`, the task is to find the longest common prefix among all strings in the array. If no common prefix exists, return an empty string `""`.

---

## Example Walkthrough

### Example 1:
- **Input**: `strs = ["flower","flow","flight"]`
- **Explanation**:  
  - The common prefix is `"fl"`, as it is present at the start of all the strings.  
- **Output**: `"fl"`

### Example 2:
- **Input**: `strs = ["dog","racecar","car"]`
- **Explanation**:  
  - There is no common prefix among the input strings.  
- **Output**: `""`

---

## Approach: Character-by-Character Comparison

### Key Observations:
1. The longest common prefix cannot exceed the length of the shortest string in the array.
2. We can compare characters of the strings one by one until a mismatch is found or we exhaust the shortest string.

### Steps:
1. **Handle Edge Cases**:  
   - If the input array is `null` or empty, return an empty string.  
2. **Find the Minimum Length String**:  
   - The length of the longest common prefix is bounded by the shortest string in the array.
3. **Compare Characters**:
   - Loop through each character index (up to the length of the shortest string).
   - Compare the character at the current index across all strings.
   - If a mismatch is found, return the prefix formed so far.
   - Otherwise, add the character to the result.
4. **Return the Result**:
   - If no mismatch is found during the comparison, return the accumulated prefix.

---

## Code Implementation

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Longest common prefix string
        StringBuilder longestCommonPrefix = new StringBuilder();
        
        // Base condition
        if (strs == null || strs.length == 0) {
            return longestCommonPrefix.toString();
        }
        
        // Find the minimum length string from the array
        int minimumLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minimumLength = Math.min(minimumLength, strs[i].length());
        }
        
        // Loop for the minimum length
        for (int i = 0; i < minimumLength; i++) {
            // Get the current character from the first string
            char current = strs[0].charAt(i);
            
            // Check if this character is found in all other strings or not
            for (String str : strs) {
                if (str.charAt(i) != current) {
                    return longestCommonPrefix.toString();
                }
            }
            
            // Add the current character to the result
            longestCommonPrefix.append(current);
        }
        
        return longestCommonPrefix.toString();
    }
}
```

---

## Complexity Analysis

### Time Complexity: \(O(S)\)
- \(S\) is the sum of all characters in the array.  
- Each character in each string is compared at most once.

### Space Complexity: \(O(1)\)
- The algorithm uses constant extra space apart from the output string.

---

## Example Walkthrough

### Example 1:
- **Input**: `strs = ["flower", "flow", "flight"]`
- **Steps**:
  1. Find the minimum string length: `minimumLength = 4` (from `"flow"`).  
  2. Compare characters index by index:
     - At index 0: All strings have `'f'`. Add `'f'` to the prefix.  
     - At index 1: All strings have `'l'`. Add `'l'` to the prefix.  
     - At index 2: Mismatch (`'o'` vs `'i'`). Stop.  
  3. Return `"fl"`.
- **Output**: `"fl"`

### Example 2:
- **Input**: `strs = ["dog", "racecar", "car"]`
- **Steps**:
  1. Find the minimum string length: `minimumLength = 3` (from `"dog"`).  
  2. Compare characters index by index:
     - At index 0: Mismatch (`'d'` vs `'r'`). Stop.  
  3. Return `""`.
- **Output**: `""`

---

## Summary

This solution is efficient for finding the longest common prefix, leveraging character-by-character comparison. It minimizes unnecessary comparisons by focusing only on the shortest string's length and stops early when a mismatch is detected.

---
