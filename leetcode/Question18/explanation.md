# Explanation: Maximum Product Subarray

## Problem Statement

Given an integer array `nums`, the task is to find a **subarray** that has the largest product, and return that product.

### Example:

- **Input**: `nums = [2,3,-2,4]`
- **Output**: `6`
- **Explanation**: The subarray `[2,3]` has the largest product, which is `6`.

- **Input**: `nums = [-2,0,-1]`
- **Output**: `0`
- **Explanation**: The largest product is `0` since multiplying negative numbers results in a negative product, and the maximum subarray product in this case is `0` (the subarray `[0]`).

---

## Approach

### Key Observations:

1. **Negative Numbers**: A negative number can turn a small product into a large one when multiplied by another negative number. Hence, we need to track both the **maximum** and **minimum** product at each position in the array.
   
2. **Zeroes**: A zero in the array resets the product sequence because multiplying by zero gives zero.

3. **Dynamic Tracking**: As we iterate through the array:
   - Track the current **maximum** product (`currentMax`) and the current **minimum** product (`currentMin`).
   - Update both values as we move through the array to ensure that we capture both positive and negative product results.

### Steps:

1. **Initialization**:
   - Initialize `max` to a very small value (`Integer.MIN_VALUE`) to store the maximum product encountered.
   - Initialize `currentMax` and `currentMin` to 1, as the product of a sequence starting with 1 is neutral.

2. **Iterate through the array**:
   - For each number, calculate the new potential maximum and minimum products.
   - If the number is `0`, reset `currentMax` and `currentMin` to 1 and continue.
   - Update the global `max` whenever `currentMax` is larger than `max`.

3. **Return the result**:
   - After iterating through the array, `max` will contain the largest product.

---

### Time Complexity:
- **O(n)**: The array is processed in a single pass.

### Space Complexity:
- **O(1)**: Only a constant amount of extra space is used.

---

## Code Implementation

```java
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int currentMin = 1, currentMax = 1;
        for (int i : nums) {
            if (i == 0) {
                currentMin = 1;
                currentMax = 1;
                continue;
            }

            // Temporary calculations to preserve previous values
            int temp = currentMax * i;
            int tempMax = Math.max(i * currentMax, i * currentMin);
            currentMax = Math.max(tempMax, i);

            int tempMin = Math.min(temp, i * currentMin);
            currentMin = Math.min(tempMin, i);

            max = Math.max(currentMax, max);
        }

        return max;
    }
}
```

---

## Explanation:

1. **Initialization**:
   - `max` is set to `Integer.MIN_VALUE` to ensure that any product found in the array will be larger.
   - `currentMin` and `currentMax` are initialized to `1` as the product of any sequence that starts with `1` is neutral.

2. **Loop through the array**:
   - For each number:
     - If it's `0`, reset the `currentMin` and `currentMax` because zero breaks any subarray multiplication.
     - Calculate the new possible `currentMax` and `currentMin` based on the previous values and the current number:
       - **`tempMax`**: The maximum of the product of `i` and the previous `currentMax`, or the product of `i` and the previous `currentMin`.
       - **`tempMin`**: The minimum of the product of `i` and the previous `currentMax`, or the product of `i` and the previous `currentMin`.
     - Update `max` with the largest value between `max` and `currentMax`.

3. **Return the maximum product**:
   - After processing all elements, `max` holds the largest product of any subarray.

---

## Example Walkthrough

### Example 1: `nums = [2,3,-2,4]`

- **Initialization**: `max = Integer.MIN_VALUE`, `currentMax = 1`, `currentMin = 1`.
- **Iteration**:
  - Day 1: Price = 2 → `currentMax = 2`, `currentMin = 2`, `max = 2`.
  - Day 2: Price = 3 → `currentMax = 6`, `currentMin = 3`, `max = 6`.
  - Day 3: Price = -2 → `currentMax = -12`, `currentMin = -2`, `max = 6`.
  - Day 4: Price = 4 → `currentMax = 4`, `currentMin = -48`, `max = 6`.

Result: The largest product is `6`.

### Example 2: `nums = [-2,0,-1]`

- **Initialization**: `max = Integer.MIN_VALUE`, `currentMax = 1`, `currentMin = 1`.
- **Iteration**:
  - Day 1: Price = -2 → `currentMax = -2`, `currentMin = -2`, `max = -2`.
  - Day 2: Price = 0 → Reset `currentMax = 1`, `currentMin = 1`.
  - Day 3: Price = -1 → `currentMax = -1`, `currentMin = -1`, `max = 0`.

Result: The largest product is `0`.

---

## Conclusion

The approach efficiently tracks both the maximum and minimum products at each step to handle both positive and negative numbers. By updating the `currentMax` and `currentMin` values dynamically, we ensure that the solution runs in **O(n)** time complexity while using **O(1)** space.​
