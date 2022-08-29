class Solution {
    public void moveZeroes(int[] nums) {
     
        int left = 0;
        int right = 0;
        
        while(right < nums.length) {
            
            while(left < nums.length && nums[left] != 0) {
                left++;
            }
            
            right = left;
            
            while(right < nums.length && nums[right] == 0) {
                right++;
            }
            
            if(right < nums.length) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            
        }
    }
}

/*

[0,0,0,0]
 l
         r


 0 1 2 3 4
[1,3,0,0,12]
     l
          r
 

- left should point the first zero
- right should point non-zero



[1,0,0,2,3,0]
   l
       r




*/