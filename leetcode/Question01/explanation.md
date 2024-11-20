# Explanation: Two Sum

## Problem Statement
The problem requires finding two indices `i` and `j` in an array `nums` such that `nums[i] + nums[j] == target`. Each input is guaranteed to have **exactly one solution**, and we cannot use the same element twice.

---

## Approach: Using a Hash Map (Optimal Solution)
To solve the problem efficiently in \(O(n)\) time complexity, we utilize a **hash map** (`numMap`) to store the numbers we've already encountered along with their indices. This allows us to quickly check if the complement of the current number (i.e., `target - nums[i]`) exists in the array.

---

## Steps in the Algorithm
1. **Initialize a Hash Map**:
   - Create a `HashMap<Integer, Integer>` named `numMap` where:
     - The key represents the number from the array.
     - The value represents the index of that number.

2. **Iterate through the Array**:
   - For each element `nums[i]`:
     - Calculate its **complement** as `complement = target - nums[i]`.
     - Check if `complement` exists in `numMap`:
       - If yes:
         - Return the indices `[numMap.get(complement), i]`.
         - These indices satisfy the condition `nums[i] + nums[j] == target`.
       - If no:
         - Store the current number `nums[i]` in `numMap` with its index `i`.

3. **Return the Result**:
   - Since the problem guarantees exactly one solution, the loop will always find and return the answer.

---

## Complexity Analysis

### Time Complexity: \(O(n)\)
- We traverse the array once, and each lookup/insert operation in a hash map takes \(O(1)\) on average.
- Thus, the overall time complexity is linear with respect to the size of the array.

### Space Complexity: \(O(n)\)
- In the worst case, we may store all \(n\) elements of the array in the hash map.

---

## Example Walkthrough

### Example 1:
**Input**: `nums = [2, 7, 11, 15]`, `target = 9`  
- Initialize `numMap = {}`.
- Loop through `nums`:
  1. For `i = 0`, `nums[i] = 2`:
     - `complement = 9 - 2 = 7`.
     - `7` is not in `numMap`.
     - Add `2` to `numMap`: `{2: 0}`.
  2. For `i = 1`, `nums[i] = 7`:
     - `complement = 9 - 7 = 2`.
     - `2` exists in `numMap` with index `0`.
     - Return `[0, 1]`.

**Output**: `[0, 1]`

---

### Example 2:
**Input**: `nums = [3, 2, 4]`, `target = 6`  
- Initialize `numMap = {}`.
- Loop through `nums`:
  1. For `i = 0`, `nums[i] = 3`:
     - `complement = 6 - 3 = 3`.
     - `3` is not in `numMap`.
     - Add `3` to `numMap`: `{3: 0}`.
  2. For `i = 1`, `nums[i] = 2`:
     - `complement = 6 - 2 = 4`.
     - `4` is not in `numMap`.
     - Add `2` to `numMap`: `{3: 0, 2: 1}`.
  3. For `i = 2`, `nums[i] = 4`:
     - `complement = 6 - 4 = 2`.
     - `2` exists in `numMap` with index `1`.
     - Return `[1, 2]`.

**Output**: `[1, 2]`

---

### Example 3:
**Input**: `nums = [3, 3]`, `target = 6`  
- Initialize `numMap = {}`.
- Loop through `nums`:
  1. For `i = 0`, `nums[i] = 3`:
     - `complement = 6 - 3 = 3`.
     - `3` is not in `numMap`.
     - Add `3` to `numMap`: `{3: 0}`.
  2. For `i = 1`, `nums[i] = 3`:
     - `complement = 6 - 3 = 3`.
     - `3` exists in `numMap` with index `0`.
     - Return `[0, 1]`.

**Output**: `[0, 1]`

---

## Edge Cases
1. **Small Input Size**:
   - Example: `nums = [1, 2]`, `target = 3`.
   - Solution works for the smallest valid input sizes.

2. **Negative Numbers**:
   - Example: `nums = [-3, 4, 3, 90]`, `target = 0`.
   - Solution correctly handles negative values.

3. **All Elements Same**:
   - Example: `nums = [2, 2, 2, 2]`, `target = 4`.
   - Solution ensures that different indices are returned.

---

## Summary
This solution efficiently finds two indices whose elements sum to the target by leveraging a hash map for constant-time lookups. The approach ensures an optimal runtime and handles a wide range of inputs effectively.
