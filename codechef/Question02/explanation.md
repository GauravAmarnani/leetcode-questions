# Explanation of Solution

The goal of this problem is to determine the maximum number of friendships Devu can save by hosting a single party per day. For each test case, Devu’s friends demand parties on specific days, but if multiple friends want a party on the same day, he can only host one due to the one-party-per-day limitation.

### Approach
1. **Data Structure**:
   - We use an integer array `temp` of size 101 (since day values range from 1 to 100) to keep track of whether Devu has already hosted a party on each day.

2. **Counting Unique Days**:
   - For each friend’s requested day `d_i`:
     - If `temp[d_i]` is 0, it means Devu hasn’t yet hosted a party on day `d_i`, so he can save this friendship by scheduling a party on that day.
     - We set `temp[d_i]` to 1 to indicate that Devu has already scheduled a party for day `d_i`.
     - We increment `total` by 1 for each unique day (each friendship saved).
   - This ensures that each unique day requested by a friend is counted only once, allowing Devu to maximize the number of friendships he can save without hosting multiple parties on the same day.

3. **Output Collection**:
   - For each test case, after processing all friends’ requested days, the count of unique days (stored in `total`) is saved in the `output` array, which stores results for all test cases.
   - Finally, we print each result from the `output` array.

### Why this Solution is Efficient
- This approach is efficient as it processes each friend’s request in constant time \(O(1)\) using the `temp` array for each friend’s day request.
- The solution operates in linear time relative to the number of friends for each test case, i.e., \(O(n)\), making it well-suited for the problem constraints (\(n \leq 50\) and \(T \leq 10,000\)).

### Edge Cases
- **All friends want parties on the same day**: Devu can save only one friendship, as he can host only one party on that day.
- **Each friend wants a party on a different day**: Devu can save all friendships since there are no overlapping requests for the same day.
- **Single friend**: With only one friend, Devu can save that friendship as there’s no conflict in party scheduling.

This solution is both simple and effective due to the use of an array to track unique days and ensures that Devu can save as many friendships as possible.
