# Chef and Dolls

Chef is a fan of pairs and loves things that come in pairs. He even has a doll collection where the dolls come in pairs. However, one day while checking his collection, he noticed an odd number of dolls, meaning one doll was missing its pair!

Your task is to help Chef find the type of doll that doesn’t have a pair.

### Input
- The first line contains an integer `T`, the number of test cases.
- The first line of each test case contains an integer `N`, the number of dolls.
- The next `N` lines are the types of dolls that are left.

### Output
For each test case, output the type of doll that doesn't have a pair, on a new line.

### Constraints
- 1<=T<=10
- 1<=N<=100000 (10^5)
- 0<=type<=100000

### Sample Input
1 3 1 2 1


### Sample Output
2


### Explanation
In the sample case, we have three dolls `[1, 2, 1]`. Dolls of type 1 have a pair, but there’s only one doll of type 2. Hence, the doll of type 2 is missing its pair.
