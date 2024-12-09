# Explanation: Remove Duplicates from Sorted Array

## Problem Statement
Given an integer array `nums` sorted in non-decreasing order, remove the duplicates **in-place** such that each unique element appears only once. The relative order of the elements should be kept the same. Then, return the number of unique elements in the array.

The solution should modify the array in-place, and after the removal of duplicates, the first `k` elements should contain the unique elements. The remaining elements do not matter.

### Constraints:
- `1 <= nums.length <= 30,000`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in non-decreasing order.

---

## Approach: In-Place Removal of Duplicates

### Key Observations
1. The array is sorted in non-decreasing order, which means that duplicate elements will always appear consecutively.
2. The problem asks to remove duplicates in-place, meaning we should not use extra space that scales with the input size, other than the space for the result.
3. The goal is to overwrite the duplicates in the array without using additional space for a new array.

### Approach
1. We will use a pointer (`counter`) to track the position of the next unique element.
2. We iterate through the `nums` array, comparing each element to the last unique element added (pointed to by `counter`).
3. If the current element is different from the last unique element, it is added to the result by moving `counter` forward and replacing the value at the `counter` position with the current element.
4. The number of unique elements will be the value of `counter` after processing the entire array.

### Steps in the Algorithm:
1. Initialize `counter = 1` because the first element is always unique.
2. Iterate through the array starting from the second element:
   - If the current element is different from the previous one, place it in the `counter`-th position and increment `counter`.
3. Return `counter`, which represents the number of unique elements.

### Time Complexity: \(O(n)\)
- We iterate through the array once. Each operation inside the loop (comparison and assignment) is constant time, so the overall time complexity is linear.

### Space Complexity: \(O(1)\)
- The algorithm modifies the array in place without using extra space for storing the result (other than the variable `counter`).

---

## Code Implementation

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: empty or single-element array
        if (nums.length == 0) {
            return 0;
        }

        // Counter to track the position of unique elements
        int counter = 1;

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous one
            if (nums[i] != nums[i - 1]) {
                // Move the unique element to the next position
                nums[counter] = nums[i];
                counter++;
            }
        }

        // Return the number of unique elements
        return counter;
    }
}
```

---

## Example Walkthrough

### Example 1:
- **Input**: `nums = [1, 1, 2]`
- **Steps**:
  1. Initialize `counter = 1`.
  2. At index 1, `nums[1] = 1`, which is the same as `nums[0]`. So, no action is taken.
  3. At index 2, `nums[2] = 2`, which is different from `nums[1]`. Move it to `nums[1]` and increment `counter` to 2.
  4. The first 2 elements of the array are now `[1, 2]`, and `counter = 2`.
- **Output**: `2`, and `nums = [1, 2, _]`.

### Example 2:
- **Input**: `nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]`
- **Steps**:
  1. Initialize `counter = 1`.
  2. At index 1, `nums[1] = 0`, which is the same as `nums[0]`. No action.
  3. At index 2, `nums[2] = 1`, which is different from `nums[1]`. Move it to `nums[1]` and increment `counter` to 2.
  4. Continue for all other elements. At the end, the first 5 elements will be `[0, 1, 2, 3, 4]`.
  5. Return `counter = 5`.
- **Output**: `5`, and `nums = [0, 1, 2, 3, 4, _, _, _, _, _]`.

---

## Summary
This solution efficiently removes duplicates from a sorted array in-place, modifying the array directly and ensuring the unique elements remain in the same order. It operates with \(O(n)\) time complexity and \(O(1)\) space complexity, making it optimal for large inputs.

---
