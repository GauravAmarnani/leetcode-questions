# Explanation: Palindrome Number

## Problem Statement
Given an integer `x`, the task is to determine if `x` is a palindrome number. A number is a palindrome if it reads the same backward as forward.

### Algorithm Walkthrough

The algorithm for solving this problem without converting the integer to a string is as follows:

1. **Handle Negative Numbers**:
   - If the integer is negative, it is automatically not a palindrome because the minus sign will not match in reverse. Hence, we return `false` immediately.

2. **Reverse the Number**:
   - For a non-negative number, we reverse the digits of the number by repeatedly extracting the last digit (using modulo `10`) and appending it to the reversed number.

3. **Check for Equality**:
   - After reversing the number, if the reversed number equals the original number, it is a palindrome, and we return `true`. Otherwise, we return `false`.

4. **Edge Cases**:
   - Numbers with a trailing zero (like `10`, `100`, etc.) are not palindromes because when reversed, they will not match the original number (e.g., `10` becomes `01`, which is not the same as `10`).

### Example Walkthrough

1. **Example 1**:
   - **Input**: `121`
   - **Step-by-Step**:
     - The number is positive, so we proceed.
     - Reversed number: `121` (no change).
     - Reversed number equals the original number, so the result is `true`.
   - **Output**: `true`

2. **Example 2**:
   - **Input**: `-121`
   - **Step-by-Step**:
     - The number is negative, so we immediately return `false`.
   - **Output**: `false`

3. **Example 3**:
   - **Input**: `10`
   - **Step-by-Step**:
     - The number is positive, so we proceed.
     - Reversed number: `1` (not equal to the original `10`).
     - The reversed number is not equal to the original, so the result is `false`.
   - **Output**: `false`

---

## Code Explanation

```java
class Solution {
    public boolean isPalindrome(int x) {
        // Step 1: Negative numbers are not palindromes
        if(x < 0) {
            return false;
        }
        
        // Step 2: Initialize variables to reverse the number
        int temp = 0;
        int xTemp = x;  // Store the original number to compare later
        
        // Step 3: Reverse the number
        while(x > 0) {
            temp = (temp * 10) + x % 10;  // Get the last digit and append it
            x = x / 10;  // Remove the last digit from the number
        }
        
        // Step 4: Check if the reversed number is equal to the original number
        return temp == xTemp;
    }
}
```

### Key Concepts

- **Negative Numbers**: A negative number cannot be a palindrome because the negative sign would not match when reversed.
- **Reversing the Number**: By using modulo operation (`x % 10`), we extract the last digit and build the reversed number. We then discard the last digit of `x` by dividing it by 10.
- **Equality Check**: After reversing, we compare the reversed number with the original number (`xTemp`). If they are the same, it is a palindrome.

---

## Complexity Analysis

### Time Complexity: \(O(\log_{10} x)\)
- The time complexity is proportional to the number of digits in `x`. In each step of the loop, the number is reduced by a factor of 10 (due to integer division). Thus, the number of iterations is the number of digits in `x`, which is logarithmic.

### Space Complexity: \(O(1)\)
- The space complexity is constant because we only use a few integer variables (`temp`, `xTemp`, and `x`) to hold intermediate values.

---

## Edge Cases Considered

1. **Negative Numbers**: Automatically return `false` since negative numbers cannot be palindromes.
2. **Trailing Zeros**: Numbers like `10`, `100`, etc., are not palindromes because they lose their trailing zeros when reversed.
3. **Single-Digit Numbers**: Any single-digit number is always a palindrome (e.g., `5`, `0`).

---

## Summary

The solution efficiently checks if a number is a palindrome by reversing the digits and comparing it to the original number. It does this without converting the number to a string, providing a clean and performant solution with \(O(\log_{10} x)\) time complexity and \(O(1)\) space complexity.

---
