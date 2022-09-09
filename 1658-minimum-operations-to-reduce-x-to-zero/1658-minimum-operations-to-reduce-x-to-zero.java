// class Solution {
//     Map<String, Integer> memo = new HashMap<>();
//     public int minOperations(int[] nums, int x) {
//         return helper(nums, x, 0, nums.length - 1);
//     }
    
//     public int helper(int[] nums, int x, int begin, int end) {
//         if(x == 0) return 0;
//         if(x < 0 || begin > end) return -1;
        
//         String key = begin + "," + end;
//         if(memo.containsKey(key)) return memo.get(key);
        
//         int left = helper(nums, x - nums[begin], begin + 1, end);
//         int right = helper(nums, x - nums[end], begin, end - 1);
        
//         if(left >= 0 && right >= 0) {
//             memo.put(key, 1 + Math.min(left, right));
//             return 1 + Math.min(left, right);
//         }
//         else if(left >= 0) {
//             memo.put(key, 1 + left);
//             return 1 + left;
//         }
//         else if(right >= 0) {
//             memo.put(key, 1 + right);
//             return 1 + right;
//         }
//         memo.put(key, -1);
//         return -1;
//     }
// }

class Solution {
    public int minOperations(int[] nums, int x) {
    
        int total = 0; 
        for(int i : nums) total += i;
        int rem = total - x;
        int left = 0, right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while(right < nums.length) {
            int curr = nums[right];
            sum += curr;
            
            while(left <= right && sum > rem) {
                sum -= nums[left];
                left++;
            }
            
            if(sum == rem) {
                min = Math.min(min, nums.length - (right - left + 1));
            }
            right++;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}






/*

nums = [1,1,4,2,3], x = 5
 
                    [1,1,4,2,3]
            [1,4,2,3],4         [1,1,4,2],2
        4,2,3 3   1,4,2 1      1,4,2 1    1,1,4 0          




*/