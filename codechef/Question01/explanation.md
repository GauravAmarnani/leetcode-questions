# Explanation of Solution

This solution efficiently identifies the type of doll that doesn't have a matching pair by leveraging the properties of a `HashMap`.

### Approach
1. **Understanding the Problem**: 
   - We have multiple test cases, and for each test case, there’s a collection of doll types where all but one type will have an even count (since they form pairs).
   - The task is to find the single doll type that has no pair.

2. **Data Structure**: 
   - We use a `HashMap<Integer, Integer>` called `myMap` to store the doll types and track pairs:
      - The keys in `myMap` represent the doll types.
      - The values would indicate if the doll of a specific type is paired (added or removed from the map).

3. **Pairing Mechanism**:
   - We iterate through each doll type in the list:
      - If a doll type already exists in `myMap`, we remove it. This means we’ve found a pair for this type.
      - If a doll type is not in `myMap`, we add it, signifying it currently has no pair.
   - At the end of this loop, only one unpaired doll type will remain in `myMap` as all paired doll types would have been removed.

4. **Iterating through Test Cases**:
   - We read the number of test cases `T`.
   - For each test case, we initialize a counter for the number of dolls `N`.
   - Using a nested loop, we process each doll type as described above and apply the pairing logic using `myMap`.
   - After processing each test case, the remaining entry in `myMap` will be the unpaired doll type, which we then store in an `output` array.
   - We reset `myMap` after each test case to ensure it doesn’t carry over data to the next test case.

5. **Handling Edge Cases**:
   - If there’s no unpaired doll, an exception would occur. However, based on the problem constraints, there will always be one unpaired doll, so the try-catch block is a safeguard.
   
6. **Output**:
   - After iterating through all test cases, we print each result from the `output` array.
   - This method is efficient, utilizing only a single `HashMap` and a linear time complexity in each test case (i.e., \(O(N)\) per test case), which is well-suited for the input constraints.

### Why this Solution Works
Using a `HashMap` allows efficient insertion and deletion (average \(O(1)\) complexity), making this solution optimal for large inputs (up to \(10^5\) dolls in each test case). The solution’s logic ensures that only unpaired types remain, and its efficiency meets the problem’s constraints comfortably.
