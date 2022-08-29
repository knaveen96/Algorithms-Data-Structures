class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0, right = 0;
        int n = nums.length;
        int minLength = Integer.MAX_VALUE; //4
        int currWindowSum = 0; //8
        
        /*
         0 1 2 3 4 5
        [2,3,1,2,4,3]
         l
               r
        
        */
        
        while(right < n) {
            currWindowSum += nums[right];
            
            if(currWindowSum >= target) {
                while(left < n && currWindowSum >= target) {
                    minLength = Math.min(right - left + 1, minLength);
                    currWindowSum -= nums[left];
                    left++;
                }
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

/*

target = 7, nums = [2,3,1,2,4,3]


- ? >= target



 0 1 2 3 4 5
[2,3,1,2,4,3]
 l
       r
 right - left + 1 will give me the window size
 
 - increment right until 
 


*/