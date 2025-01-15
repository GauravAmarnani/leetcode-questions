# Explanation: Pascal's Triangle

## Problem Statement

Given an integer `numRows`, you need to return the first `numRows` of **Pascal's Triangle**.

### Constraints:
- `1 <= numRows <= 30`

### Example:

- **Input**: `numRows = 5`
- **Output**: `[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]`

- **Input**: `numRows = 1`
- **Output**: `[[1]]`

---

## Approach

**Pascal's Triangle** is a triangular array where:
- The first and last elements of each row are `1`.
- Any other element is the sum of the two elements directly above it in the previous row.

### Steps to Construct Pascal’s Triangle:
1. Start with the first row `[1]`.
2. For each subsequent row:
   - The first and last elements are always `1`.
   - Each in-between element is the sum of two numbers from the row above it (the one directly above left and the one directly above right).

### Time Complexity:
- **O(n²)**: Each row `i` has `i` elements, and we have to calculate the elements for `n` rows.

### Space Complexity:
- **O(n²)**: We store the entire triangle, which requires space proportional to the total number of elements in the triangle, which is `n(n+1)/2`.

---

## Code Implementation

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows <= 0)
            return triangle;

        // First row of Pascal's Triangle
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        // Construct the triangle row by row
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // The first and last element of each row are always 1
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    // Other elements are the sum of two elements from the row above
                    currentRow.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(currentRow);
        }
        return triangle;
    }
}
```

---

## Explanation:

1. **Initialization**:
   - Start with an empty list of lists called `triangle` to hold the rows.
   - The first row `[1]` is manually added to the `triangle`.

2. **Loop for each row**:
   - For each row `i` (starting from 1):
     - A new `currentRow` list is created.
     - For each position `j` in the row:
       - If `j == 0` (first element) or `j == i` (last element), add `1` to the `currentRow`.
       - Otherwise, the value at `currentRow[j]` is the sum of `triangle[i-1][j-1]` and `triangle[i-1][j]`, the elements from the previous row.

3. **Return the result**:
   - Finally, return the entire `triangle` list, which now contains the first `numRows` of Pascal's Triangle.

---

## Example Walkthrough

### Example 1: `numRows = 5`

1. **Row 1**: `[1]`
2. **Row 2**: `[1, 1]`
3. **Row 3**: `[1, 2, 1]`
4. **Row 4**: `[1, 3, 3, 1]`
5. **Row 5**: `[1, 4, 6, 4, 1]`

The final output is: `[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]`.

### Example 2: `numRows = 1`

1. **Row 1**: `[1]`

The final output is: `[[1]]`.

---

## Conclusion

This approach effectively builds Pascal's Triangle row by row, using the properties of Pascal's Triangle to fill in the appropriate values. The solution is efficient and works within the given constraints.​
