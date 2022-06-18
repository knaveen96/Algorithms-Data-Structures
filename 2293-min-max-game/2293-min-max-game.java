class Solution {
    public int minMaxGame(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        return merge(nums, 0, nums.length - 1, true);
    }
    
    public int merge(int[] nums, int low, int high, boolean min) {
        
        if(low == high) {
            return nums[low];
        }
        
        int mid = (low + high) / 2;
        
        int left = merge(nums, low, mid, true);
        int right = merge(nums, mid + 1, high, false);
        
        return min == true ? Math.min(left, right) : Math.max(left, right);
    }
}