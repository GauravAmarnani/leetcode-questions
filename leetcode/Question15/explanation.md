# Explanation: Merge Sorted Array

## Problem Statement

You are given two integer arrays `nums1` and `nums2`, both sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2`, respectively. Your task is to merge the two arrays into a single sorted array, and store the result in `nums1`.

### Constraints:
- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-10^9 <= nums1[i], nums2[j] <= 10^9`

### Input:
- Two arrays: `nums1` and `nums2`.
- Two integers: `m` and `n`.

---

## Approach

The goal is to merge the two sorted arrays `nums1` and `nums2` into `nums1`. We have a few strategies for merging, but the most optimal solution is to use the **two-pointer approach** to avoid sorting the merged array.

### Steps:

1. **Array Size**:
   - `nums1` is already large enough to hold the merged array because it has a size of `m + n`, with the last `n` elements initialized as `0`. We will overwrite these `0` elements with elements from `nums2`.

2. **Two Pointer Technique**:
   - Start from the last element of `nums1` (i.e., the position `m + n - 1`) and the last element of `nums2` (i.e., position `n - 1`).
   - Compare the elements from the end of both arrays and place the larger one in the last available position in `nums1`. Then, move the pointer for the array whose element was just added.
   - Continue this process until either `nums1` or `nums2` is completely merged.

3. **Handling Leftover Elements**:
   - If any elements are left in `nums2`, copy them into `nums1`. If `nums1` still has remaining elements (which will already be in their correct place), no action is needed.

### Time Complexity:
- **O(m + n)**: We are iterating through both arrays only once.

### Space Complexity:
- **O(1)**: The operation is done in-place, requiring no extra space besides the input arrays.

---

## Code Implementation

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        
        // Merge the two arrays starting from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        // If there are still elements in nums2, copy them over
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
```

---

## Example Walkthrough

### Example 1:
- **Input**: `nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3`
- **Steps**:
  - Start from the end of both arrays: `nums1[i = 2]` and `nums2[j = 2]`.
  - Compare `3` and `6`. Since `6` is larger, place `6` at the end of `nums1` (`nums1[k = 5]`).
  - Repeat the process until both arrays are merged.
- **Output**: `[1, 2, 2, 3, 5, 6]`

### Example 2:
- **Input**: `nums1 = [1], m = 1, nums2 = [], n = 0`
- **Steps**:
  - `nums2` is empty, so no changes are made.
- **Output**: `[1]`

### Example 3:
- **Input**: `nums1 = [0], m = 0, nums2 = [1], n = 1`
- **Steps**:
  - The `nums1` array has no valid elements, so we copy the elements of `nums2` into `nums1`.
- **Output**: `[1]`

---

## Summary

The two-pointer approach provides an efficient way to merge two sorted arrays in **O(m + n)** time complexity, which meets the problem's requirement. This solution modifies `nums1` in-place without using extra space, making it both time and space efficient.
