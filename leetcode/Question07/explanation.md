# Explanation: Container With Most Water

## Problem Statement
You are given an array `height` where each element represents the height of a vertical line drawn at that index. The task is to find two lines such that the container formed between them, along with the x-axis, can store the maximum amount of water.

---

## Example Walkthrough

### Example 1:
- **Input**: `height = [1,8,6,2,5,4,8,3,7]`  
- **Explanation**: The two lines at indices `1` and `8` (heights `8` and `7`, respectively) form the container with the maximum area.  
  - The width is `8 - 1 = 7`.  
  - The height is `min(8, 7) = 7`.  
  - The area is `7 * 7 = 49`.  
- **Output**: `49`

### Example 2:
- **Input**: `height = [1,1]`  
- **Explanation**: The two lines at indices `0` and `1` form the container.  
  - The width is `1 - 0 = 1`.  
  - The height is `min(1, 1) = 1`.  
  - The area is `1 * 1 = 1`.  
- **Output**: `1`

---

## Approach: Two Pointers

### Key Observations:
1. **Width-Height Trade-off**:
   - The area of the container depends on the width between two lines and the height of the shorter line.  
   - The area is given by the formula:  
     \[
     \text{area} = \text{width} \times \min(\text{height[left]}, \text{height[right]})
     \]

2. **Optimal Strategy**:
   - Start with the widest container (using the first and last lines).  
   - Gradually narrow the container by moving the pointer pointing to the shorter line, as the height of the container can only increase if we find a taller line.  

### Steps:
1. Initialize two pointers:  
   - `left` at the beginning of the array (`0`).  
   - `right` at the end of the array (`n-1`).  

2. Calculate the area for the container formed by `height[left]` and `height[right]`.  

3. Update the `max` area encountered so far.  

4. Move the pointer pointing to the shorter line:  
   - If `height[left] < height[right]`, increment `left`.  
   - Otherwise, decrement `right`.  

5. Repeat steps 2-4 until `left < right`.  

---

## Code Implementation

```java
class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;  // To store the maximum area
        int left = 0;                 // Pointer at the beginning
        int right = height.length - 1; // Pointer at the end
        int area = 0;                 // To store the current area
        
        while (left < right) {
            // Calculate the area between lines at indices left and right
            area = (right - left) * Math.min(height[left], height[right]);
            
            // Update the maximum area if the current area is greater
            max = Math.max(area, max);
            
            // Move the pointer pointing to the shorter line
            if (height[left] > height[right]) 
                right--;
            else 
                left++;
        }
        
        return max;  // Return the maximum area found
    }
}

```

---

## Complexity Analysis

### Time Complexity: \(O(n)\)  
- Each line is visited at most once, as the two pointers move toward each other.

### Space Complexity: \(O(1)\)  
- Only a few integer variables are used.

---

## Example Walkthrough

### Example 1:
**Input**: `height = [1,8,6,2,5,4,8,3,7]`  
- **Initialization**: `left = 0`, `right = 8`, `max = Integer.MIN_VALUE`.  
- **Step 1**:  
  - Area = \((8 - 0) \times \min(1, 7) = 8 \times 1 = 8\).  
  - Update `max = 8`.  
  - Move `left` because `height[0] < height[8]`.  
- **Step 2**:  
  - Area = \((8 - 1) \times \min(8, 7) = 7 \times 7 = 49\).  
  - Update `max = 49`.  
  - Move `right` because `height[1] > height[8]`.  
- Continue similarly until `left < right`.  

**Output**: `49`

---

## Summary

This two-pointer approach efficiently finds the container with the maximum area in \(O(n)\) time. It leverages the trade-off between width and height, dynamically adjusting the container's boundaries to maximize the area.​

---
