# Explanation: Maximum Subarray

## Problem Statement
Given an integer array `nums`, find the **subarray** with the largest sum and return its sum.

### Constraints:
- \(1 \leq \text{nums.length} \leq 10^5\)
- \(-10^4 \leq \text{nums[i]} \leq 10^4\)

---

## Approach

This problem is commonly solved using **Kadane's Algorithm**, which works by iterating through the array and dynamically updating the maximum subarray sum encountered so far. The key idea is to decide at each step whether to continue adding the current element to the existing subarray or start a new subarray starting from the current element.

### Key Concepts:
1. **Current Sum**: 
   - Keep track of the sum of the current subarray.
   - If the current sum becomes negative, it means starting a new subarray from the next element might give a better result, so we reset it to 0.

2. **Max Sum**: 
   - Keep track of the maximum sum encountered at any point during the iteration.

### Algorithm:
1. Initialize `maxSum` to the first element of the array.
2. Initialize `currentSum` to 0.
3. Iterate through the array:
   - If `currentSum` is negative, reset it to 0 (this means we start a new subarray).
   - Add the current element to `currentSum`.
   - Update `maxSum` to be the maximum of `maxSum` and `currentSum`.
4. Return `maxSum` as the result.

### Time Complexity:
- **O(n)** where `n` is the length of the array because we are only iterating through the array once.

### Space Complexity:
- **O(1)** since we are only using a constant amount of extra space.

---

## Code Implementation

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        
        for (int i : nums) {
            if (currentSum < 0)
                currentSum = 0;  // Start a new subarray if currentSum is negative
            currentSum += i;
            maxSum = Math.max(currentSum, maxSum);  // Update the max sum found so far
        }
        return maxSum;
    }
}
```

---

## Example Walkthrough

### Example 1:
- **Input**: `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`
- **Steps**:
  1. Iterate through the array and update `currentSum` and `maxSum`.
  2. The subarray `[4, -1, 2, 1]` has the maximum sum of 6.
- **Output**: `6`

### Example 2:
- **Input**: `nums = [1]`
- **Steps**:
  1. Since there's only one element, the maximum subarray sum is that element itself.
- **Output**: `1`

### Example 3:
- **Input**: `nums = [5, 4, -1, 7, 8]`
- **Steps**:
  1. The subarray `[5, 4, -1, 7, 8]` has the maximum sum of 23.
- **Output**: `23`

---

## Summary

Kadane's algorithm efficiently solves the Maximum Subarray problem in **O(n)** time. By dynamically updating the current subarray sum and tracking the maximum sum encountered, we are able to solve this problem with minimal space and time overhead. This approach ensures optimal performance for large arrays.​
