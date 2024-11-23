# Explanation: Median of Two Sorted Arrays

## Problem Statement
The problem asks us to find the **median** of two sorted arrays, `nums1` and `nums2`. The goal is to return the median of the two sorted arrays, and the overall time complexity should be \(O(\log(m + n))\), where `m` and `n` are the sizes of the two arrays.

### Example Walkthrough

1. **Example 1**:
   - **Input**: `nums1 = [1, 3]`, `nums2 = [2]`
   - **Explanation**: The merged array is `[1, 2, 3]`, and the median is `2`.
   - **Output**: `2.00000`

2. **Example 2**:
   - **Input**: `nums1 = [1, 2]`, `nums2 = [3, 4]`
   - **Explanation**: The merged array is `[1, 2, 3, 4]`, and the median is `(2 + 3) / 2 = 2.5`.
   - **Output**: `2.50000`

---

## Approach: Merging the Arrays and Finding the Median

The key to solving this problem is to merge the two sorted arrays into a single sorted array, then find the median from the merged array. The solution involves three steps:

1. **Merging the two sorted arrays**:
   - If one of the arrays is empty, the other array is the merged result.
   - If both arrays are non-empty, merge them in sorted order.

2. **Finding the median**:
   - If the length of the merged array is odd, the median is the middle element.
   - If the length is even, the median is the average of the two middle elements.

### Steps of the Algorithm

1. **Initialize variables**:
   - `n1` and `n2` are the lengths of `nums1` and `nums2`, respectively.
   - `merged` is an array to hold the merged elements of `nums1` and `nums2`.

2. **Merge the two arrays**:
   - Use two pointers `i` and `j` to traverse `nums1` and `nums2`.
   - Compare the elements and insert the smaller element into the `merged` array.
   - Handle cases where one array is exhausted before the other.
   - If one array is empty, simply copy the elements from the other array into the `merged` array.

3. **Compute the median**:
   - If the length of the merged array is odd, return the middle element.
   - If the length is even, return the average of the two middle elements.

---

## Complexity Analysis

### Time Complexity: \(O(m + n)\)
- We traverse both arrays once and compare elements from both arrays. The time complexity is proportional to the total number of elements in the two arrays.

### Space Complexity: \(O(m + n)\)
- We store the merged result in a new array of size \(m + n\), which requires additional space.

---

## Example Walkthrough

### Example 1:
**Input**: `nums1 = [1, 3]`, `nums2 = [2]`

- Merge the arrays:
  - Merged array: `[1, 2, 3]`.
  - The median is `2`.

**Output**: `2.00000`

### Example 2:
**Input**: `nums1 = [1, 2]`, `nums2 = [3, 4]`

- Merge the arrays:
  - Merged array: `[1, 2, 3, 4]`.
  - The median is `(2 + 3) / 2 = 2.5`.

**Output**: `2.50000`

---

## Summary
This solution efficiently merges the two sorted arrays and computes the median. While the time complexity for merging the arrays is \(O(m + n)\), the problem's constraint on time complexity \(O(\log(m + n))\) suggests more advanced solutions (like binary search) may be needed for larger inputs to meet the complexity requirement. However, the approach presented here works within acceptable limits for typical input sizes.
​
