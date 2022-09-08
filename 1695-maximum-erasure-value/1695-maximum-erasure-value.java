class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int left = 0, right = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int maxSum = 0;
        
        while(right < nums.length) {
            int curr = nums[right]; //4
            sum += curr; //4
            
            while(set.contains(curr)) {
                int leftVal = nums[left];
                set.remove(leftVal);
                sum -= leftVal;
                left++;
            }
            maxSum = Math.max(maxSum, sum);
            right++;
            set.add(curr);
        }
        return maxSum;
    }
}

/*

 0 1 2 3 4
[4,2,4,5,6]
 l
 r

sum = 6
set

2
4

*/