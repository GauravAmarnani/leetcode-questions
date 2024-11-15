# Equal Elements

You are given an array `A` of size `N`. In one operation, you can select indices `i` and `j` (`i ≠ j`) and set `A[i] = A[j]`. The goal is to determine the minimum number of operations required to make all elements of the array equal.

### Input Format
- The first line contains an integer `T`, denoting the number of test cases.
- For each test case:
  - The first line contains an integer `N`, the size of the array.
  - The second line contains `N` space-separated integers representing the array `A`.

### Output Format
For each test case, output the minimum number of operations required to make all elements of the array equal, in a new line.

### Constraints
- \(1 \leq T \leq 1000\)
- \(1 \leq N \leq 2 \cdot 10^5\)
- \(1 \leq A[i] \leq N\)
- The sum of \(N\) over all test cases won't exceed \(2 \cdot 10^5\).

### Sample Input
3 3 1 2 3 4 2 2 3 1 4 3 1 2 4


### Sample Output
2 2 3


### Explanation
- **Test Case 1**: The minimum number of operations is 2. Transform the array `[1, 2, 3]` into `[2, 2, 2]`.
- **Test Case 2**: The minimum number of operations is 2. Transform `[2, 2, 3, 1]` into `[2, 2, 2, 2]`.
- **Test Case 3**: The minimum number of operations is 3. Transform `[3, 1, 2, 4]` into `[3, 3, 3, 3]`.
