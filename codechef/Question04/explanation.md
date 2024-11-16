# Explanation of Solution

## Approach
To determine if there is a dominant element in the array, we perform the following steps for each test case:

1. **Frequency Calculation:**
   - Use a `HashMap` to store the frequency of each element in the array.
   - Traverse the array and for each element, increase its count in the `HashMap`.

2. **Identify Maximum Frequency:**
   - Traverse the `HashMap` to find the element with the highest frequency (`maxValue`).
   - Track if this element is unique by comparing its frequency to others in the `HashMap`.

3. **Decision:**
   - If the element with the highest frequency is unique, it is a dominant element, and the result for the test case is `YES`.
   - If there are multiple elements with the same maximum frequency, the result is `NO`.

## Complexity Analysis
1. **Time Complexity:**
   - For each test case:
     - Calculating frequencies takes \(O(N)\), where \(N\) is the size of the array.
     - Finding the maximum frequency takes \(O(K)\), where \(K\) is the number of unique elements (at most \(N\)).
   - Overall complexity for all test cases is approximately \(O(\text{Sum of all } N \text{ over } T)\).

2. **Space Complexity:**
   - We use a `HashMap` to store frequencies, which requires \(O(K)\) space per test case.

## Example Walkthrough
### Input:
4 5 2 2 2 2 2 4 1 2 3 4 4 3 3 2 1 6 1 1 2 2 3 4

### Execution:
1. **Test Case 1:**
   - Array: `[2, 2, 2, 2, 2]`
   - Frequencies: `{2: 5}`
   - Maximum Frequency: `5` (unique)
   - Result: `YES`

2. **Test Case 2:**
   - Array: `[1, 2, 3, 4]`
   - Frequencies: `{1: 1, 2: 1, 3: 1, 4: 1}`
   - No unique maximum frequency.
   - Result: `NO`

3. **Test Case 3:**
   - Array: `[3, 3, 2, 1]`
   - Frequencies: `{3: 2, 2: 1, 1: 1}`
   - Maximum Frequency: `2` (unique for `3`)
   - Result: `YES`

4. **Test Case 4:**
   - Array: `[1, 1, 2, 2, 3, 4]`
   - Frequencies: `{1: 2, 2: 2, 3: 1, 4: 1}`
   - No unique maximum frequency.
   - Result: `NO`

### Output:
YES NO YES NO
