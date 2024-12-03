class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        
        while(left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(area, max);
            
            if(height[left] > height[right]) 
                right--;
            else
                left++;
        }
        return max;
    }
}
