class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(nums, target, true);
        if(ans[0] != -1)
            ans[1] = search(nums, target, false);
        return ans;
    }

    public static int search(int[] nums, int target, boolean isSearchingForFirstIndex) {
        int left = 0, right = nums.length - 1, ans = -1;
        while(left <= right) {
            int mid = left + (right - left)/ 2;
            if(target < nums[mid])
                right = mid - 1;
            else if(target > nums[mid])
                left = mid + 1;
            else {
                ans = mid;
                if(isSearchingForFirstIndex)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return ans;
    }
}
