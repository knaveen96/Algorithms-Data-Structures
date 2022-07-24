// class Solution {
//     public int search(int[] nums, int target) {
        
//         int left = 0;
//         int right = nums.length - 1;
        
//         while(left < right) {
             
//             int mid = (left + right) / 2;
            
//             if(nums[mid] > nums[right]) 
//                 left = mid + 1;
            
//             else
//                 right = mid;
                
//         }
//         System.out.println(left);
//         int start = left;
//         left = 0;
//         right = nums.length - 1;
        
//         if(target >= nums[start] && target <= nums[right])
//             left = start;
        
//         else
//             right = start;
        
//         while(left <= right) {
//             int mid = (left + right) / 2;
            
//             if(nums[mid] == target)
//                 return mid;
//             else if(nums[mid] < target)
//                 left = mid + 1;
//             else
//                 right = mid - 1;
//         }
//         return -1; 
//     }
// }



/**
         
[4,5,6,7,0,1,2]
         l r

 0 1 2 3 4 5 6 7 8
[4,5,6,7,8,9,0,1,2]
         l m r       

nums[mid] = 8
compare mid-1 and mid+1




target = 0

 0 1 2 3 4 5 6
[4,5,6,7,0,1,2]
         l
         m
         r




**/

class Solution {
    public int search(int[] nums, int target) {
        
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
        
        int start = 0;
        int end = 0;
        
        if(nums[left] <= target && target <= nums[nums.length - 1]) {
            start = left;
            end = nums.length - 1;
        }
        else {
            start = 0;
            end = left - 1;
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1; 
    }
}


/*


[4,5,6,7,0,1,2], target = 0

 0 1 2 3 4 5 6
[4,5,6,7,0,1,2]
         l
           m
           r







*/























