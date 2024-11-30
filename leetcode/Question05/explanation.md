# Explanation: String to Integer (atoi)

## Problem Statement
The task is to implement the function `myAtoi(string s)` that converts a string to a 32-bit signed integer following these rules:
1. Ignore leading whitespaces.
2. Determine if the number is negative or positive based on the first non-whitespace character (`'-'` or `'+'`).
3. Parse subsequent digits to form the integer.
4. Clamp the result to fit within the 32-bit signed integer range \([-2^{31}, 2^{31} - 1]\).
5. Return the integer, or `0` if no valid conversion can be performed.

### Example Walkthrough

1. **Example 1**:
   - **Input**: `s = "42"`
   - **Explanation**:  
     - Ignore leading whitespaces: `"42"`.  
     - No sign specified, so it defaults to positive.  
     - Parse digits: `42`.  
     - The result `42` is within range.  
   - **Output**: `42`

2. **Example 2**:
   - **Input**: `s = "   -42"`
   - **Explanation**:  
     - Ignore leading whitespaces: `"   -42" → "-42"`.  
     - Negative sign detected.  
     - Parse digits: `42`, then apply the negative sign: `-42`.  
     - The result `-42` is within range.  
   - **Output**: `-42`

3. **Example 3**:
   - **Input**: `s = "4193 with words"`
   - **Explanation**:  
     - No leading whitespaces to remove.  
     - No sign specified, so it defaults to positive.  
     - Parse digits: `4193`. Parsing stops at the first non-digit character.  
     - The result `4193` is within range.  
   - **Output**: `4193`

---

## Approach: Parsing and Validating the String

The solution reads the input string character by character, converts valid digits to an integer, and applies necessary constraints to ensure the result fits within the 32-bit signed integer range.

### Steps:

1. **Trim Leading Whitespaces**:
   - Use regular expressions or manual iteration to remove any leading spaces from the string.

2. **Check for a Sign**:
   - Detect a `'-'` or `'+'` character immediately after the leading spaces. Set a flag (`isNegative`) to determine the sign of the result.

3. **Extract Digits**:
   - Start reading digits until a non-digit character or the end of the string is encountered. Ignore invalid characters beyond this point.

4. **Clamp the Range**:
   - Before appending each digit to the result, ensure the intermediate result doesn't exceed the 32-bit signed integer boundaries \([-2^{31}, 2^{31} - 1]\).

5. **Return the Result**:
   - Return the parsed and clamped integer. If no valid digits were read, return `0`.

---

## Complexity Analysis

### Time Complexity: \(O(n)\)
- Each character in the input string is processed once, where \(n\) is the length of the string.

### Space Complexity: \(O(1)\)
- Only a constant amount of extra space is used for variables (`number`, `isNegative`, etc.).

---

## Example Walkthrough

### Example 1:
**Input**: `s = "42"`
- Trim leading spaces: `"42"`.  
- No sign detected → default positive.  
- Extract digits: `42`.  
- Clamp result: Not needed, as `42` is within range.  
**Output**: `42`

### Example 2:
**Input**: `s = "   -42"`
- Trim leading spaces: `"   -42" → "-42"`.  
- Negative sign detected.  
- Extract digits: `42`.  
- Apply negative sign: `-42`.  
- Clamp result: Not needed, as `-42` is within range.  
**Output**: `-42`

### Example 3:
**Input**: `s = "4193 with words"`
- Trim leading spaces: `"4193 with words"`.  
- No sign detected → default positive.  
- Extract digits: `4193`. Parsing stops at the first non-digit.  
- Clamp result: Not needed, as `4193` is within range.  
**Output**: `4193`

---

## Algorithm

### Code:

```java
class Solution {
    public int myAtoi(String str) {
        // Step 1: Handle empty input
        if (str == null || str.isEmpty()) 
            return 0;

        // Step 2: Trim leading whitespaces
        str = str.trim();

        // Step 3: Handle sign
        int i = 0;
        boolean isNegative = false;
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            isNegative = (str.charAt(i) == '-');
            i++;
        }

        // Step 4: Convert digits
        long number = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            number = number * 10 + (str.charAt(i) - '0');
            if (!isNegative && number > Integer.MAX_VALUE) 
                return Integer.MAX_VALUE;
            if (isNegative && -number < Integer.MIN_VALUE) 
                return Integer.MIN_VALUE;
            i++;
        }

        // Step 5: Apply sign and return
        return isNegative ? (int) -number : (int) number;
    }
}
```
---

# Summary

This solution efficiently parses and converts a string to a 32-bit signed integer, handling edge cases like:

- Invalid input (e.g., "words and 987" → 0).
- Overflow and underflow.
- Mixed characters (e.g., "4193 with words" → 4193).

---

### By carefully following the constraints and ensuring no unnecessary operations, the implementation is both optimal and reliable.

