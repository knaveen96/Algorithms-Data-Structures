class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, graph, list);
        return res;
    }
    
    public void dfs(int index, int[][] graph, List<Integer> list) {
        
        if(index == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int nextIndex : graph[index]) {
            list.add(nextIndex);
            dfs(nextIndex, graph, list);
            list.remove(list.size() - 1);
        }
    }
}


/*
[[1,2],[3],[3],[]]




*/