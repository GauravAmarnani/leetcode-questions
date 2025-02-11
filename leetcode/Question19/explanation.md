# Explanation: Two Sum II - Input Array Is Sorted

## Problem Statement

Given a **1-indexed** array of integers `numbers` sorted in **non-decreasing order**, and a target integer `target`, the task is to find two numbers in the array such that their sum equals the `target`. Return the **indices** of the two numbers in the array, **added by one** (since the array is 1-indexed).

### Example:

- **Input**: `numbers = [2, 7, 11, 15]`, `target = 9`
- **Output**: `[1, 2]`
- **Explanation**: The sum of `2` and `7` is `9`, so the indices are `1` and `2`.

- **Input**: `numbers = [2, 3, 4]`, `target = 6`
- **Output**: `[1, 3]`
- **Explanation**: The sum of `2` and `4` is `6`, so the indices are `1` and `3`.

---

## Approach

### Key Observations:
1. **Sorted Array**: Since the array is sorted in **non-decreasing order**, we can leverage the two-pointer technique to find the pair whose sum equals the target in **linear time**.
   
2. **Two-pointer Technique**:
   - **Left pointer** (`l`): Starts at the beginning of the array.
   - **Right pointer** (`r`): Starts at the end of the array.
   - We calculate the sum of the elements at the left and right pointers.
     - If the sum is equal to the target, we return the indices (adjusted for 1-based indexing).
     - If the sum is greater than the target, we move the right pointer leftward (decrease the sum).
     - If the sum is less than the target, we move the left pointer rightward (increase the sum).

3. **Termination**: Since there is exactly one solution, the loop will always find the solution before pointers cross.

### Steps:
1. Initialize two pointers: `l` (left) at index 0, and `r` (right) at the last index.
2. While `l` is less than `r`:
   - Compute the sum of `numbers[l] + numbers[r]`.
   - If the sum equals the target, return `[l+1, r+1]` (1-indexed result).
   - If the sum is greater than the target, decrement `r` (move left).
   - If the sum is less than the target, increment `l` (move right).
3. Return the result.

### Time Complexity:
- **O(n)**: The array is processed in a single pass using the two-pointer technique.

### Space Complexity:
- **O(1)**: The solution uses constant extra space.

---

## Code Implementation

```java
class Solution {
    public int[] twoSum(int[] n, int t) {
        int l = 0;
        int r = n.length - 1;
        while (l <= r) {
            int s = n[l] + n[r];
            if (s > t) 
                r -= 1;
            else if (s < t) 
                l += 1;
            else 
                return new int[] {l + 1, r + 1};  // Return 1-based indices
        }
        return new int[] {l + 1, r + 1};  // This case won't occur as per problem constraints
    }
}
```

---

## Explanation:

1. **Two pointers (`l` and `r`)**:
   - `l` starts at `0` (first element), and `r` starts at `n.length - 1` (last element).
   
2. **Loop through the array**:
   - Calculate the sum of the numbers at the two pointers.
   - If the sum equals the target, return the indices (1-based).
   - If the sum is greater than the target, move the right pointer left to decrease the sum.
   - If the sum is less than the target, move the left pointer right to increase the sum.

3. **Exit condition**: The loop exits as soon as we find the solution, which is guaranteed to exist.

---

## Example Walkthrough

### Example 1: `numbers = [2, 7, 11, 15]`, `target = 9`

- **Initialization**: `l = 0`, `r = 3`.
- **First iteration**:
  - `numbers[0] + numbers[3] = 2 + 15 = 17` (greater than 9).
  - Move `r` to `2`.
- **Second iteration**:
  - `numbers[0] + numbers[2] = 2 + 11 = 13` (greater than 9).
  - Move `r` to `1`.
- **Third iteration**:
  - `numbers[0] + numbers[1] = 2 + 7 = 9` (equal to the target).
  - Return `[1, 2]`.

### Example 2: `numbers = [2, 3, 4]`, `target = 6`

- **Initialization**: `l = 0`, `r = 2`.
- **First iteration**:
  - `numbers[0] + numbers[2] = 2 + 4 = 6` (equal to the target).
  - Return `[1, 3]`.

---

## Conclusion

By using the two-pointer technique, we can efficiently solve the problem in linear time while adhering to the constant space constraint. The approach leverages the fact that the array is already sorted, making it ideal for this method.​
