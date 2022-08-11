// class Solution {
//     public int findPairs(int[] nums, int k) {
        
//         Map<Integer, Integer> map = new HashMap<>();
//         int count = 0;
        
//         for(int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
        
//         for(int key : map.keySet()) {
            
//             if(k != 0 && map.containsKey(key + k)) {
//                 count++;
//             }
//             else if(k == 0 && map.get(key) > 1) {
//                 count++;
//             }
//         }
        
//         return count;
//     }
// }



class Solution {
    public int findPairs(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
            int iVal = nums[i];
            int jVal = iVal - k;
            
            if(k == 0) {
                if(map.get(jVal) > 1) {
                    count++;
                    map.put(jVal,0);
                }
            }
            else if(map.get(iVal) > 0 && map.containsKey(jVal)) {
                count++;
                map.put(iVal, 0);
            }
        }
        return count;
            
    }
}



/*

[3,1,1,3] k = 2

3 - 2
1 - 2



       
[3,1,4,1,5], k = 2
         j

nums[i] - nums[j] = k

nums[i] = k + nums[j]





3, 0



*/