class Solution {
    public int maximumGap(int[] nums) {
        
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxGap = 0;
        
        if(n < 2) return 0;
        
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int buckets = n - 1;
        int[] minVal = new int[buckets];
        int[] maxVal = new int[buckets];
        Arrays.fill(minVal, Integer.MAX_VALUE);
        Arrays.fill(maxVal, Integer.MIN_VALUE);
        int bucketSize = (int) Math.ceil((double)(max - min) / buckets);
    
        for(int i = 0 ; i < n ; i++) {
            if(nums[i] == min || nums[i] == max) continue;
            int indexOfNum = (nums[i] - min) / bucketSize;
            
            minVal[indexOfNum] = Math.min(minVal[indexOfNum], nums[i]);
            maxVal[indexOfNum] = Math.max(maxVal[indexOfNum], nums[i]);
        }
                
        for(int i = 0 ; i < buckets ; i++) {
            if(maxVal[i] == Integer.MIN_VALUE) continue;
            
            maxGap = Math.max(maxGap, minVal[i] - min);
            min = maxVal[i];
        }
        
        maxGap = Math.max(maxGap, max - min);
        
        return maxGap;
        
    }
}

/*

O(N), O(N)

[3,6,9,1]

[1,3,6,9]

                    3
                1       6
                            9



*/