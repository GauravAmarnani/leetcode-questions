# Explanation: Reverse Integer

## Problem Statement
The problem requires us to reverse the digits of a given signed 32-bit integer `x`. If reversing the integer results in a value that goes outside the range of a signed 32-bit integer \([-2^{31}, 2^{31} - 1]\), the function should return `0`.

### Example Walkthrough

1. **Example 1**:
   - **Input**: `x = 123`
   - **Explanation**: The digits of `x` are reversed to get `321`.
   - **Output**: `321`

2. **Example 2**:
   - **Input**: `x = -123`
   - **Explanation**: The digits of `x` are reversed to get `-321`.
   - **Output**: `-321`

3. **Example 3**:
   - **Input**: `x = 120`
   - **Explanation**: The digits of `x` are reversed to get `21` (removing the trailing zero).
   - **Output**: `21`

---

## Approach: Reversing the Integer with Range Checks

The goal is to reverse the digits of the given integer while ensuring that the result stays within the 32-bit signed integer range. Here's the detailed breakdown:

1. **Extract digits**:
   - We can extract the last digit of `num` by taking the remainder of `num` when divided by 10 (`num % 10`).
   - We then remove the last digit from `num` by performing integer division by 10 (`num /= 10`).

2. **Check for overflow**:
   - Since the result could overflow, we need to check whether the reversed number (`rev`) will exceed the 32-bit integer boundaries.
   - If `rev` exceeds `Integer.MAX_VALUE / 10`, then multiplying `rev` by 10 would cause overflow. Similarly, if `rev` is equal to `Integer.MAX_VALUE / 10`, we check if the remainder (`rem`) is greater than `7` (since the last digit of `Integer.MAX_VALUE` is `7`).
   - Similarly, for negative overflow, if `rev` is less than `Integer.MIN_VALUE / 10`, or if `rev == Integer.MIN_VALUE / 10` and `rem < -8`, the result would overflow.

3. **Reverse the digits**:
   - If no overflow occurs, we multiply `rev` by 10 and add the remainder (`rem`) to it. This builds the reversed number step by step.

4. **Return the result**:
   - If the result is within the valid 32-bit signed integer range, return `rev`. Otherwise, return `0`.

### Algorithm

1. Initialize `rev = 0` to store the reversed number.
2. While `num != 0`, repeat the following:
   - Calculate the last digit (`rem = num % 10`).
   - Remove the last digit from `num` (`num /= 10`).
   - Check for overflow conditions.
   - Update `rev = rev * 10 + rem`.
3. After the loop ends, return the reversed number `rev` if no overflow occurred. Otherwise, return `0`.

---

## Complexity Analysis

### Time Complexity: \(O(\log_{10} x)\)
- The time complexity is proportional to the number of digits in the integer `x`, which is logarithmic in terms of base 10.

### Space Complexity: \(O(1)\)
- The space complexity is constant because we only use a few integer variables (`rev`, `rem`).

---

## Example Walkthrough

### Example 1:
**Input**: `x = 123`
- Reversed digits: `321`.
- The result is within the 32-bit integer range.
- **Output**: `321`

### Example 2:
**Input**: `x = -123`
- Reversed digits: `-321`.
- The result is within the 32-bit integer range.
- **Output**: `-321`

### Example 3:
**Input**: `x = 120`
- Reversed digits: `21` (trailing zero is discarded).
- The result is within the 32-bit integer range.
- **Output**: `21`

---

## Summary
This solution efficiently handles the reversal of a 32-bit integer while preventing overflow by checking the result at each step. The approach ensures the solution works within the time and space constraints for typical input sizes.
​
