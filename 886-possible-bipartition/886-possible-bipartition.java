class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        int[] colors = new int[n + 1];
        
        Arrays.fill(colors, - 1);
        
        for(int i = 1 ; i <= n + 1 ; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] dislike : dislikes) {
            adjList.get(dislike[0]).add(dislike[1]);
            adjList.get(dislike[1]).add(dislike[0]);
        }
        
        for(int i = 1 ; i <= n ; i++) {
            if(colors[i] == -1) {
                if(!bfs(adjList, i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean bfs(List<List<Integer>> adjList, int node, int[] colors) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = 1;
        
        while(!queue.isEmpty()) {
            
            int curr = queue.poll();
            int currColor = colors[curr];
            
            for(int nextNode : adjList.get(curr)) {
                
                if(colors[nextNode] == currColor) {
                        return false;
                }
                if(colors[nextNode] == -1) {
                    queue.add(nextNode);
                    colors[nextNode] = 1 - currColor;
                }
            }
        }
        return true;
    }
}



/*

1 - 2,3
2 - 1,4
3 - 1
4 - 2

1-2-4
|
3

  1 2 3 4
[ 1 -1-1-1]



1 - 2,3
2 - 1,3
3 - 1,2


1 2 3
1 0 0


visited = {1,2}

[1] [2] 

*/