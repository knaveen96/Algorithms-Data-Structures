class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n < 3) return true;
        int count = 0;
        
        for(int i = 1 ; i < n ; i++) {
            if(nums[i - 1] > nums[i]) {
                count++;
                if(i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                }
                else {
                    nums[i] = nums[i - 1];
                }
                if(count > 1) return false;
            }
        }
        return true;
    }
}

/*
 0 1 2 3 4 5 6 
[4,5,6,7,3,1,2]


4,5,6,6,6,6

 0 1 2 3
[3,4,2,3]
     ^
     
[5,7,7,5]   

[1,2,2,3]
if(nums[i - 2] < nums[i]) -> change nums[i - 1]
if(nums[i - 2] > nums[i]) -> change nums[i]


*/