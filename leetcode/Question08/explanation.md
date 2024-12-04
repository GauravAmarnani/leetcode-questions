​# Explanation: Roman to Integer

## Problem Statement
Roman numerals are composed of seven symbols, each representing a specific value:
Symbol       Value
I            1
V            5
X            10
L            50
C            100
D            500
M            1000

The task is to convert a valid Roman numeral string to its corresponding integer value. Roman numerals are typically written from largest to smallest from left to right, with exceptions for cases involving subtraction (e.g., IV = 4, IX = 9).

---

## Example Walkthrough

### Example 1:
- **Input**: `s = "III"`
- **Explanation**:  
  - `I = 1`, `I = 1`, `I = 1`.  
  - Total: \(1 + 1 + 1 = 3\).  
- **Output**: `3`

### Example 2:
- **Input**: `s = "LVIII"`
- **Explanation**:  
  - `L = 50`, `V = 5`, `III = 3`.  
  - Total: \(50 + 5 + 3 = 58\).  
- **Output**: `58`

### Example 3:
- **Input**: `s = "MCMXCIV"`
- **Explanation**:  
  - `M = 1000`, `CM = 900`, `XC = 90`, `IV = 4`.  
  - Total: \(1000 + 900 + 90 + 4 = 1994\).  
- **Output**: `1994`

---

## Approach: Single Pass from Right to Left

### Key Observations:
1. Roman numerals can have subtraction-based combinations:
   - `IV = 4` (\(5 - 1\)), `IX = 9` (\(10 - 1\)).
   - `XL = 40` (\(50 - 10\)), `XC = 90` (\(100 - 10\)).
   - `CD = 400` (\(500 - 100\)), `CM = 900` (\(1000 - 100\)).
2. For a given Roman numeral `s`:
   - If the current numeral is **greater than or equal to** the next numeral, add its value.  
   - Otherwise, subtract its value (indicating a subtraction combination).

### Steps:
1. Use a `HashMap` to map each Roman numeral to its integer value.  
2. Start from the last character (rightmost numeral) and initialize the result with its value.  
3. Traverse the string from right to left:
   - If the current numeral is greater than or equal to the numeral on its right, add its value.  
   - Otherwise, subtract its value.  
4. Return the final result.

---

## Code Implementation

```java
class Solution {
    public int romanToInt(String s) {
        // Map to store Roman numerals
        Map<Character, Integer> romanMap = new HashMap<>();
        
        // Populate the map
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        // Length of the given string
        int n = s.length();
        // Variable to store the result
        int num = romanMap.get(s.charAt(n - 1));
        
        // Traverse the string from right to left
        for (int i = n - 2; i >= 0; i--) {
            // If the current numeral is greater than or equal to the next, add it
            if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i + 1))) {
                num += romanMap.get(s.charAt(i));
            } 
            // Otherwise, subtract it
            else {
                num -= romanMap.get(s.charAt(i));
            }
        }
        
        return num;
    }
}
```

---

## Complexity Analysis

### Time Complexity: \(O(n)\)
- The solution involves a single traversal of the string of length \(n\).  

### Space Complexity: \(O(1)\)
- The `romanMap` is fixed in size (constant space).  

---

## Example Walkthrough

### Example 1:
- **Input**: `s = "MCMXCIV"`  
- **Steps**:  
  1. Initialize `num = 4` (value of `IV` from the last numeral).  
  2. Add `90` for `XC`.  
  3. Add `900` for `CM`.  
  4. Add `1000` for `M`.  
- **Output**: `1994`.

### Example 2:
- **Input**: `s = "LVIII"`  
- **Steps**:  
  1. Initialize `num = 3` (`III`).  
  2. Add `5` for `V`.  
  3. Add `50` for `L`.  
- **Output**: `58`.

---

## Summary
This efficient approach converts Roman numerals to integers in \(O(n)\) time. It takes advantage of the subtraction rule by processing the string from right to left, ensuring correctness for all valid inputs within the range [1, 3999].

---
