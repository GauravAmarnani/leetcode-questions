# Explanation: Valid Parentheses

## Problem Statement
Given a string `s` containing only the characters `()[]{}`, determine if the input string is valid based on the following conditions:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket must have a corresponding open bracket of the same type.

---

## Examples

### Example 1
- **Input**: `s = "()"`  
- **Output**: `true`  
- **Explanation**: The string contains a single pair of parentheses that is valid.

### Example 2
- **Input**: `s = "()[]{}"`  
- **Output**: `true`  
- **Explanation**: Each pair of brackets is closed properly and in the correct order.

### Example 3
- **Input**: `s = "(]"`  
- **Output**: `false`  
- **Explanation**: The closing bracket `]` does not match the opening bracket `(`.

---

## Approach: Using a Stack

### Key Observations
1. The stack data structure is well-suited for problems involving matching parentheses, as it allows us to process elements in a Last In, First Out (LIFO) manner.
2. When encountering an opening bracket, push it onto the stack.
3. When encountering a closing bracket:
   - Check if the stack is empty. If it is, return `false` because there is no matching opening bracket.
   - Otherwise, check if the top of the stack matches the current closing bracket. If it doesn't, return `false`. If it does, pop the stack.

4. After processing all characters:
   - If the stack is empty, all brackets were matched correctly, and the input is valid.
   - If the stack is not empty, there are unmatched opening brackets, so the input is invalid.

---

## Steps in the Algorithm
1. Create a `Stack` to store opening brackets.
2. Iterate through the characters in the string:
   - Push opening brackets onto the stack.
   - For closing brackets, use a helper function to check if the top of the stack matches. If it doesn't, return `false`.
3. After the iteration, check if the stack is empty. If it is, return `true`; otherwise, return `false`.

---

## Code Implementation

```java
import java.util.Stack;

class Solution {
    public boolean handleClosing(Stack<Character> stack, char openBracket) {
        // If stack is empty, no matching open bracket
        if (stack.size() == 0) {
            return false;
        }
        // Check if the top of the stack matches the expected open bracket
        if (stack.peek() != openBracket) {
            return false;
        }
        // Pop the matching bracket from the stack
        stack.pop();
        return true;
    }

    public boolean isValid(String s) {
        // Stack to store open brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // Push open brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Handle closing brackets
            else if (ch == ')') {
                if (!handleClosing(stack, '(')) return false;
            } else if (ch == '}') {
                if (!handleClosing(stack, '{')) return false;
            } else if (ch == ']') {
                if (!handleClosing(stack, '[')) return false;
            }
        }
        
        // If stack is empty, all brackets were matched
        return stack.isEmpty();
    }
}
```

---

## Complexity Analysis

### Time Complexity: \(O(n)\)
- The algorithm iterates through the string once. Each operation on the stack (push and pop) is \(O(1)\).
- Thus, the time complexity is linear with respect to the length of the input string.

### Space Complexity: \(O(n)\)
- In the worst case, the stack may store all opening brackets, resulting in \(O(n)\) space usage.

---

## Example Walkthrough

### Example 1
- **Input**: `s = "()"`  
- **Steps**:
  1. Push `'('` onto the stack.
  2. Handle `')'`: Top of the stack is `'('`. Pop it.
  3. The stack is empty. Return `true`.
- **Output**: `true`.

### Example 2
- **Input**: `s = "()[]{}"`  
- **Steps**:
  1. Push `'('`, handle `')'`, pop `'('`.
  2. Push `'['`, handle `']'`, pop `'['`.
  3. Push `'{'`, handle `'}'`, pop `'{'`.
  4. The stack is empty. Return `true`.
- **Output**: `true`.

### Example 3
- **Input**: `s = "(]"`  
- **Steps**:
  1. Push `'('`.
  2. Handle `']'`: Top of the stack is `'('`, which doesn't match. Return `false`.
- **Output**: `false`.

---

## Summary

This solution uses a stack to efficiently check if the brackets are valid. It processes each character in the input string once and ensures all constraints are satisfied.

---
