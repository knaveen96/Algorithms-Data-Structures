class Solution {
    public int minStartValue(int[] nums) {
    
        int len = nums.length;
        int left = 1;
        int right = len * 100 + 2;
        int minVal = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(check(nums, mid)) {
                right = mid - 1;
                minVal = mid;
            } 
            else {
                left = mid + 1;
            }
        }
        return minVal;   
    }
    
    public boolean check(int[] nums, int startVal) {
        int val = startVal;
        for(int num : nums) {
            val += num;
            if(val < 1) {
                return false;
            }
        }
        return true;
    }
}


/*

[-3,-2,-1]


[-100,-100,-100]


*/