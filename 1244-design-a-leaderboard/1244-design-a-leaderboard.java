class Leaderboard {

    Map<Integer, Integer> map;
    
    public Leaderboard() {
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        
        map.putIfAbsent(playerId, 0);
        map.put(playerId, map.get(playerId) + score);
    }
    
    public int top(int K) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(
         (arr1, arr2) -> arr1 - arr2);
        int sum = 0;
        
        for(int key : map.keySet()) {
            heap.add(map.get(key));
            if(heap.size() > K) {
                heap.poll();
            }
        }
        
        while(heap.size() > 0) {
            sum += heap.poll();
        }
        
        return sum;
    }
    
    public void reset(int playerId) {
        map.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */


/*
1 - 0
2 - 51
3 - 39
4 - 51
5 - 4





*/





