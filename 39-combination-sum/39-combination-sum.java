class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        backtrack(candidates, 0, target, new ArrayList<>(), 0);
        return res;
    }
    
    public void backtrack(int[] candidates, int idx, int target, List<Integer> curr, int sum) {
        
        if(target == sum) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(sum > target) {
            return;
        }
        
        for(int i = idx ; i < candidates.length ; i++) {
            curr.add(candidates[i]);
            backtrack(candidates, i, target, curr, sum + candidates[i]);
            curr.remove(curr.size() - 1);
        }
        
    }
    
}


/*
                         0 1 2 3 
                        [2,3,6,7]
                2       3        6       7
                        
                        


*/