# Devu and Friendship Testing

Devu has `n` friends who each want a grand party on a specific day to test their friendship with him. If Devu doesn’t host a party for a friend on their chosen day, that friend will break off the friendship. 

Devu, despite his wealth, is frugal and can only host one party per day, and he can only invite one friend to each party. Given this, find the maximum number of friendships Devu can save by hosting parties on specific days.

### Input
- The first line contains an integer `T`, the number of test cases.
- For each test case:
  - The first line contains an integer `n`, the number of friends.
  - The second line contains `n` integers, where each integer `d_i` represents the day a friend wants a party.

### Output
For each test case, output the maximum number of friendships Devu can save.

### Constraints
- \(1 \leq T \leq 10^4\)
- \(1 \leq n \leq 50\)
- \(1 \leq d_i \leq 100\)

### Sample Input

2 2 3 2 2 1 1

### Sample Output

2 1


### Explanation
- In the first test case, Devu can save both friendships by hosting one party on day 2 and another on day 3.
- In the second test case, both friends want a party on day 1. Since Devu can host only one party per day, he can save only one friendship.
