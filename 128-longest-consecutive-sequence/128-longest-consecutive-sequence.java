class Solution {
    
    public int longestConsecutive(int[] nums) {
        
         if(nums.length == 0)
            return 0; 
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            set.add(nums[i]);
        }

        int maxCount = 1;
        
        for(int i = 0 ; i < nums.length ; i++) {
            
            if(!set.contains(nums[i] - 1)){
                int count = 1;
                int element = nums[i];
            
                while(set.contains(element+1)) {
                
                    element++;
                    count++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}


/**

[100,4,200,1,3,2]
take 100. check if we have 101
if yes then increment count and update maxcount
if no move on to the next element and make count 0.
at last return the maxcount.

**/
