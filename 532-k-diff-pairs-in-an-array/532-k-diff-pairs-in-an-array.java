class Solution {
    public int findPairs(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int key : map.keySet()) {
            
            if(k != 0 && map.containsKey(key + k)) {
                count++;
            }
            else if(k == 0 && map.get(key) > 1) {
                count++;
            }
        }
        
        return count;
    }
}


/*
       
[3,1,4,1,5], k = 2
         j

nums[i] - nums[j] = k

nums[i] = k + nums[j]





3, 0



*/