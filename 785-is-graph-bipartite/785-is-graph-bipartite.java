class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for(int i = 0 ; i < n ; i++) {
            if(colors[i] == -1) {
                if(!bfs(graph, i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean bfs(int[][] graph, int node, int[] colors) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = 1;
        
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            
            for(int nextNode : graph[currNode]) {
                if(colors[currNode] == colors[nextNode]) {
                    return false;
                }
                if(colors[nextNode] == -1) {
                    queue.add(nextNode);
                    colors[nextNode] = 1 - colors[currNode];
                }
            }
        }
        return true;
    }
}

/*

*/