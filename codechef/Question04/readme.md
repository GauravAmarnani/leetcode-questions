# Dominant Element

## Problem Description

You are given an array `A` of length `N`. An element `X` is said to be dominant if the frequency of `X` in `A` is strictly greater than the frequency of any other element in the `A`.

For example, if `A = [2, 1, 4, 4, 4]`, then `4` is a dominant element since its frequency is higher than the frequency of any other element in `A`.

### Input Format
- The first line of input contains a single integer `T` — the number of test cases. Then the test cases follow.
- The first line of each test case contains an integer `N` — the size of the array `A`.
- The second line of each test case contains `N` space-separated integers `A[1], A[2], ..., A[N]` denoting the array `A`.

### Output Format
For each test case, output `YES` if there exists any dominant element in `A`. Otherwise, output `NO`.

### Constraints
- \(1 \leq T \leq 500\)
- \(1 \leq N \leq 1000\)
- \(1 \leq A[i] \leq N\)

### Sample Input
4 5 2 2 2 2 2 4 1 2 3 4 4 3 3 2 1 6 1 1 2 2 3 4

### Sample Output
YES NO YES NO

### Explanation
1. **Test Case 1:** `2` is the dominant element.
2. **Test Case 2:** There does not exist any dominant element.
3. **Test Case 3:** `3` is the dominant element.
4. **Test Case 4:** No dominant element exists.

---

## Solution

The solution involves using a `HashMap` to count the frequencies of each element in the array and determine if there is a unique element with the highest frequency.
