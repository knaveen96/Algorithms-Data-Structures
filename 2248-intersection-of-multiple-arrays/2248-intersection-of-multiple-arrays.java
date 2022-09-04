class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums[0]) set.add(num);
        
        for(int i = 1 ; i < nums.length ; i++) {
            Set<Integer> newSet = new HashSet<>();
            int[] curr = nums[i];
            
            for(int num : curr) {
                if(set.contains(num)) {
                    newSet.add(num);
                }
            }
            set = newSet;
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        return list;
    }
}


/*

[3,1,2,4,5]
[1,2,3,4]
[3,4,5,6]

3 1 2 4 5





*/