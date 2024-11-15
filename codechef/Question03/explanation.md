# Explanation of Solution

The problem requires determining the minimum number of operations needed to make all elements in an array equal. Each operation allows you to set one element equal to another, so the goal is to minimize operations by maximizing the count of the most frequent element.

---

### Approach

1. **Count Frequencies**:
   - For each test case, use a `HashMap` to count the occurrences of each element in the array.

2. **Find the Most Frequent Element**:
   - Identify the element that appears the most in the array using the maximum value from the frequency map.

3. **Calculate Operations**:
   - To make all elements equal to the most frequent one, the minimum number of operations required is:
     \[
     \text{Operations} = N - \text{Frequency of the Most Frequent Element}
     \]
   - This is because we only need to transform all the other elements (i.e., \(N - \text{max frequency}\)).

4. **Store Results**:
   - Store the result for each test case and reset the frequency map for the next test case.

5. **Output Results**:
   - Print the results for all test cases in order.

---

### Why This Solution Works
- **Efficiency**:
  - Counting element frequencies for an array of size \(N\) is \(O(N)\).
  - Finding the maximum frequency is \(O(K)\), where \(K\) is the number of unique elements (at most \(N\)).
  - The solution handles the sum of \(N\) across all test cases up to \(2 \cdot 10^5\) efficiently.

- **Correctness**:
  - By making all elements equal to the most frequent element, we minimize operations because fewer transformations are needed.

---

### Example Walkthrough

#### Test Case 1
Input: `3, [1, 2, 3]`
- Frequencies: `{1: 1, 2: 1, 3: 1}`
- Maximum Frequency: `1`
- Operations: \(3 - 1 = 2\)

#### Test Case 2
Input: `4, [2, 2, 3, 1]`
- Frequencies: `{2: 2, 3: 1, 1: 1}`
- Maximum Frequency: `2`
- Operations: \(4 - 2 = 2\)

#### Test Case 3
Input: `4, [3, 1, 2, 4]`
- Frequencies: `{3: 1, 1: 1, 2: 1, 4: 1}`
- Maximum Frequency: `1`
- Operations: \(4 - 1 = 3\)

---

### Edge Cases
1. **All Elements Are Already Equal**:
   - If all elements are the same, the maximum frequency is \(N\), and no operations are needed (\(N - N = 0\)).

2. **All Elements Are Different**:
   - If all elements are unique, the maximum frequency is \(1\), and \(N - 1\) operations are needed.

3. **Single Element Array**:
   - If \(N = 1\), no operations are needed as there’s nothing to transform.

This approach ensures the correct result for all scenarios while staying within the constraints.
