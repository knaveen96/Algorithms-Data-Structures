class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int num : nums1) set1.add(num);
        for(int num : nums2) set2.add(num);
        
        if(set1.size() > set2.size()) {
            return commonValues(set2, set1);
        }
        return commonValues(set1, set2);
    }
    
    public int[] commonValues(Set<Integer> set1, Set<Integer> set2) {
        
        int index = 0;
        int[] res = new int[set1.size()];
        for(int num : set1) {
            if(set2.contains(num)) res[index++] = num;
        }
        return Arrays.copyOf(res, index);
    }
}

/*


[4,9,5], nums2 = [9,4,9,8,4]



*/