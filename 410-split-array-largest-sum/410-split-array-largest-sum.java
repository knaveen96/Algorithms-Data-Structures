class Solution {
    public int splitArray(int[] nums, int m) {
        
        int n = nums.length; 
        int left = 0, right = 0;
        int res = 0;
        
        for(int num : nums) {
            right += num;
            left = Math.max(left, num);
        }
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(canSplit(nums, m, mid)) {
                res = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return res;
    }
    
    public boolean canSplit(int[] nums, int m, int splitVal) {
        
        int chunks = 1;
        int currSum = 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
            currSum += nums[i];
            if(currSum > splitVal) {
                chunks++;
                currSum = nums[i];
            }
        }
        return (chunks <= m);
    }
}

/*

[1,2,3,4,5]
1


left = 5
right = 15

left = 11
right = 15

left = 14
right = 15

left = 15
right = 15



nums = [7,2,5,10,8], m = 2


[7,2,5,10,8]

total = 32


8 -> 24

left = 8
right = 24


32/2 = 16


17 - 24 / 2 = 20

17, 20, 24



*/