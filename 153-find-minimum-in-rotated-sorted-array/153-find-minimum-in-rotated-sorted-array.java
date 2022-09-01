class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}

/*
 0 1 2 3 4 5 
[3,4,5,6,1,2]
         l
       m
         r

nums[mid] > nums[right] -> go right





*/