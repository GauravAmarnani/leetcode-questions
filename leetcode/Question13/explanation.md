# Explanation: Find First and Last Position of Element in Sorted Array

## Problem Statement
Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value. If the target is not found in the array, return `[-1, -1]`. The solution must have a time complexity of \(O(\log n)\).

### Constraints:
- \(0 \leq \text{nums.length} \leq 10^5\)
- \(-10^9 \leq \text{nums[i]} \leq 10^9\)
- `nums` is a non-decreasing array.
- \(-10^9 \leq \text{target} \leq 10^9\)

---

## Approach

We are tasked with finding the **first** and **last** positions of the `target` element in a sorted array. The key to achieving the \(O(\log n)\) time complexity is to use **binary search**.

### Key Ideas:
1. **Binary Search**: 
   - The array is sorted, so we can utilize binary search to efficiently locate elements.
   - We'll perform binary search twice:
     - Once to find the first occurrence of the target.
     - Once to find the last occurrence.
   
2. **Binary Search Details**:
   - For the **first position**: If we find the target, we continue searching in the left half to ensure it's the first occurrence.
   - For the **last position**: If we find the target, we continue searching in the right half to ensure it's the last occurrence.

3. **Time Complexity**:
   - The binary search approach ensures that we are only traversing the array logarithmically. Each search (for first and last positions) runs in \(O(\log n)\), making the total time complexity \(O(\log n)\).

### Plan:
1. Use binary search to find the first occurrence of the target.
2. If the target is found, use binary search again to find the last occurrence.
3. Return the indices of the first and last positions.

---

## Code Implementation

```java
class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(nums, target, true);  // Find the first occurrence
        if (ans[0] != -1)
            ans[1] = search(nums, target, false);  // Find the last occurrence
        return ans;
    }

    public static int search(int[] nums, int target, boolean isSearchingForFirstIndex) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                ans = mid;
                if (isSearchingForFirstIndex) {
                    right = mid - 1;  // Continue to search in the left half
                } else {
                    left = mid + 1;  // Continue to search in the right half
                }
            }
        }
        return ans;
    }
}
```

---

## Example Walkthrough

### Example 1:
- **Input**: `nums = [5,7,7,8,8,10]`, `target = 8`
- **Steps**:
  1. Perform binary search for the first occurrence of `8`. It returns index `3`.
  2. Perform binary search for the last occurrence of `8`. It returns index `4`.
  3. Return `[3, 4]`.
- **Output**: `[3, 4]`

### Example 2:
- **Input**: `nums = [5,7,7,8,8,10]`, `target = 6`
- **Steps**:
  1. Perform binary search for `6`. It is not found, so return `-1` for both the first and last positions.
- **Output**: `[-1, -1]`

### Example 3:
- **Input**: `nums = []`, `target = 0`
- **Steps**:
  1. The array is empty, so return `[-1, -1]`.
- **Output**: `[-1, -1]`

---

## Summary

This solution leverages **binary search** to find the first and last positions of a target element in a sorted array. The time complexity is \(O(\log n)\) due to the binary search approach, which ensures efficient handling even for large arrays. The space complexity is \(O(1)\) since we are not using any additional space proportional to the input size.​

---
