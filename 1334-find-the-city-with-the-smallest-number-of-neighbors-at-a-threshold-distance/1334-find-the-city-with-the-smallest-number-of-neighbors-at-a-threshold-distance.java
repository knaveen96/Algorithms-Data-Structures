// class Solution {
//     public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
//         List<int[]>[] adjList = new List[n];
//         int[][] distances = new int[n][n];
//         int[] cityCount = new int[n];
//         int city = 0;
//         int minCount = Integer.MAX_VALUE;
        
//         for(int i = 0 ; i < n ; i++) {
//             Arrays.fill(distances[i], Integer.MAX_VALUE);
//         }
        
//         for(int i = 0 ; i < n ; i++) {
//             adjList[i] = new ArrayList<>();
//         }
        
//         for(int[] edge : edges) {
//             int u = edge[0];
//             int v = edge[1];
//             int d = edge[2];
//             adjList[u].add(new int[]{v, d});
//             adjList[v].add(new int[]{u, d});
//         }
        
//         for(int i = 0 ; i < n ; i++) {
//             dijkstra(adjList, i, distances[i]);
//         }
        
//         for(int i = 0 ; i < n ; i++) {
//             for(int j = 0 ; j < n ; j++) {
//                 if(distances[i][j] <= distanceThreshold) {
//                     cityCount[i]++;
//                 }
//             }
//         }
        
//         for(int i = 0 ; i < n ; i++) {
//             if(cityCount[i] < minCount) {
//                 city = i;
//                 minCount = cityCount[i];
//             }
//         }
//         return city;
//     }
    
//     public void dijkstra(List<int[]>[] adjList, int node, int[] distances) {
        
//         PriorityQueue<int[]> queue = new PriorityQueue<>(
//             (arr1, arr2) -> arr1[1] - arr2[1]);
//         queue.add(new int[]{node, 0});
        
//         while(!queue.isEmpty()) {
//             int[] curr = queue.poll();
//             int currNode = curr[0];
//             int currDist = curr[1];
            
//             for(int[] next : adjList[node]) {
//                 int nextNode = next[0];
//                 int nextDist = next[1];
                
//                 int newDist = currDist + nextDist;
                
//                 if(newDist > distances[nextNode]) {
//                     continue;
//                 }
                
//                 queue.add(new int[]{nextNode, newDist});
//                 distances[nextNode] = newDist;
//             }
            
//         }
//     }
// }



class Solution {
    private class Edge{
        int u; int v; int weight;
        
        public Edge(int u, int v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
        
        public String toString() {
            return "[" + this.u + ", " + this.v + ", " + this.weight+"]";
        }
    }
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<Edge> edge_list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            res.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            edge_list.add(new Edge(edge[0], edge[1], edge[2]));
            edge_list.add(new Edge(edge[1], edge[0], edge[2]));
        }
        
        for(int i = 0; i < n; i++){
            int dist[] = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            
            for(int j = 0; j < n; j++){
                for(Edge curr: edge_list){
                    int source = curr.u;
                    int sink = curr.v;
                    int weight = curr.weight;

                    if(dist[source] != Integer.MAX_VALUE && dist[source]+weight < dist[sink]){
                        dist[sink] = dist[source]+weight;
                    }
                }
            }
            
            for(int j = 0; j < dist.length; j++){
                if(dist[j] != 0 && dist[j] <= distanceThreshold){
                    res.get(i).add(j);
                }
            }
            
            if(res.get(i).size() <= min){
                min = res.get(i).size();
                ans = i;
            }
        }

        return ans;
    }
}

/*


0 - [{},{},{}]
1 - {}
2 - {}



counter
 0 1 2 3
[0 0 0 0]

0 - 1
1 - 0,2,3
2 - 1,3
3 - 1,2

 0 1 2 3
[  3    ]

{2,1}

[{3,4} ]

*/