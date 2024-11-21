# Explanation: Longest Substring Without Repeating Characters

## Problem Statement
The problem requires finding the length of the **longest substring** without repeating characters from a given string `s`.

### Example Walkthrough

1. **Example 1**:
   - **Input**: `s = "abcabcbb"`
   - **Explanation**: The longest substring without repeating characters is `"abc"`, which has a length of `3`.
   - **Output**: `3`

2. **Example 2**:
   - **Input**: `s = "bbbbb"`
   - **Explanation**: The longest substring without repeating characters is `"b"`, which has a length of `1`.
   - **Output**: `1`

3. **Example 3**:
   - **Input**: `s = "pwwkew"`
   - **Explanation**: The longest substring without repeating characters is `"wke"`, which has a length of `3`. Note that `"pwke"` is not a valid substring because it is a subsequence, not a substring.
   - **Output**: `3`

---

## Approach: Sliding Window with Hash Map
The key to solving this problem efficiently is the **sliding window** technique, where we maintain a window of characters that does not contain any repeating characters. As we iterate through the string, we keep track of the characters in the window and update the window's boundaries to ensure there are no duplicates.

We use a **hash map** (`map`) to store the index of each character, which allows us to quickly check if a character exists in the current window and adjust the window's start position accordingly.

### Steps of the Algorithm

1. **Initialize variables**:
   - `n`: The length of the string.
   - `ans`: To store the length of the longest substring found so far.
   - `map`: A hash map to store the most recent index of each character.

2. **Iterate through the string**:
   - We use two pointers, `i` (start of the window) and `j` (end of the window), both initialized to `0`.
   - For each character at index `j`, we check if it has been seen before:
     - If it has, we move `i` to the right of the previous occurrence of that character (i.e., `i = max(map.get(s.charAt(j)), i)`), ensuring that the substring from `i` to `j` remains valid.
   - Update the answer with the length of the current window: `ans = max(ans, j - i + 1)`.
   - Update the position of the character in the map: `map.put(s.charAt(j), j + 1)`.

3. **Return the result**: Once the iteration completes, `ans` will contain the length of the longest substring without repeating characters.

---

## Complexity Analysis

### Time Complexity: \(O(n)\)
- We only traverse the string once (from `0` to `n`), and each character is processed at most twice (once when extending `j` and once when adjusting `i`).
- Both the lookup and insertion operations in the hash map take constant time \(O(1)\) on average.

### Space Complexity: \(O(min(n, m))\)
- The space complexity is dominated by the hash map. In the worst case, the map stores each unique character in the string. Since there are only a limited number of possible characters (assuming the string only consists of English letters, digits, symbols, and spaces), the space complexity is proportional to the size of the character set.

---

## Example Walkthrough

### Example 1:
**Input**: `s = "abcabcbb"`

- Initialize `i = 0`, `ans = 0`, and `map = {}`.
- Iterate over the string:
  1. For `j = 0`, character = `'a'`:
     - `'a'` is not in the map.
     - Update `ans = max(0, 0 - 0 + 1) = 1`.
     - Add `'a'` to the map with index `1`: `map = {'a': 1}`.
  2. For `j = 1`, character = `'b'`:
     - `'b'` is not in the map.
     - Update `ans = max(1, 1 - 0 + 1) = 2`.
     - Add `'b'` to the map with index `2`: `map = {'a': 1, 'b': 2}`.
  3. For `j = 2`, character = `'c'`:
     - `'c'` is not in the map.
     - Update `ans = max(2, 2 - 0 + 1) = 3`.
     - Add `'c'` to the map with index `3`: `map = {'a': 1, 'b': 2, 'c': 3}`.
  4. For `j = 3`, character = `'a'`:
     - `'a'` is in the map at index `1`.
     - Update `i = max(1, 1) = 1` (move `i` to the right of the previous occurrence of `'a'`).
     - Update `ans = max(3, 3 - 1 + 1) = 3`.
     - Update `'a'`'s index to `4`: `map = {'a': 4, 'b': 2, 'c': 3}`.
  5. For `j = 4`, character = `'b'`:
     - `'b'` is in the map at index `2`.
     - Update `i = max(2, 2) = 2`.
     - Update `ans = max(3, 4 - 2 + 1) = 3`.
     - Update `'b'`'s index to `5`: `map = {'a': 4, 'b': 5, 'c': 3}`.
  6. For `j = 5`, character = `'c'`:
     - `'c'` is in the map at index `3`.
     - Update `i = max(3, 3) = 3`.
     - Update `ans = max(3, 5 - 3 + 1) = 3`.
     - Update `'c'`'s index to `6`: `map = {'a': 4, 'b': 5, 'c': 6}`.
  7. For `j = 6`, character = `'b'`:
     - `'b'` is in the map at index `5`.
     - Update `i = max(5, 5) = 5`.
     - Update `ans = max(3, 6 - 5 + 1) = 3`.
     - Update `'b'`'s index to `7`: `map = {'a': 4, 'b': 7, 'c': 6}`.
  
**Output**: `3`

---

### Example 2:
**Input**: `s = "bbbbb"`

- The longest substring without repeating characters is `"b"`, so the output is `1`.

---

### Example 3:
**Input**: `s = "pwwkew"`

- The longest substring without repeating characters is `"wke"`, so the output is `3`.

---

## Summary
This solution efficiently finds the longest substring without repeating characters using the sliding window technique and a hash map. It ensures a linear time complexity of \(O(n)\), which is optimal for this problem.
