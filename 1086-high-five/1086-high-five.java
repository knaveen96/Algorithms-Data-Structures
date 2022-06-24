class Solution {
    public int[][] highFive(int[][] items) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        
        for(int[] item : items) {
            int id = item[0];
            int score = item[1];
            
            map.putIfAbsent(id, new ArrayList<>());
            map.get(id).add(score);
        }
                
        for(int key : map.keySet()) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> a - b);
            
            List<Integer> scores = map.get(key);
            
            for(int s : scores) {
                minHeap.add(s);
                if(minHeap.size() > 5) {
                    minHeap.poll();
                }
            }
            
            int sum = 0;
            while(minHeap.size() > 0) {
                sum += minHeap.poll();
            }
            res.add(new int[]{key, sum/5});
        }
        return res.toArray(new int[res.size()][]);
    }
}

/*




*/