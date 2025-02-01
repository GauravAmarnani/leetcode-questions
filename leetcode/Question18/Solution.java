class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] > max)
                max = nums[i];
        
        int currentMin = 1, currentMax = 1;
        for(int i : nums) {
            if(i == 0) {
                currentMin = 1; 
                currentMax = 1;
                continue;
            }
            int temp = currentMax * i;
            int tempMax = Math.max(i * currentMax, i * currentMin);
            currentMax = Math.max(tempMax, i);
            int tempMin = Math.min(temp, i * currentMin);
            currentMin = Math.min(tempMin, i);
            max = Math.max(currentMax, max);
        }
        return max;
    }
}
