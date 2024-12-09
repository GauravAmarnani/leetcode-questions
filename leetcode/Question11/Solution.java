class Solution {
    public int removeDuplicates(int[] nums) {
        int[] r = new int[nums.length];
        r[0] = nums[0];
        int counter = 1;
        for(int i = 1; i < nums.length; i++) {
            if(r[counter-1] != nums[i]) {
                r[counter] = nums[i];
                counter++;
            }
        }
        System.arraycopy(r, 0, nums, 0, r.length);
        return counter;
    }
}
