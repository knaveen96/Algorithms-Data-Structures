class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int[] tracker = new int[s.length()];
        Arrays.fill(tracker, -1);
        char[] smallest = new char[s.length()];
        
        for(List<Integer> pair : pairs) {
            int head1 = find(pair.get(0), tracker);
            int head2 = find(pair.get(1), tracker);
            
            union(head1, head2, tracker);
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            int head = find(i, tracker);
            if(!map.containsKey(head)) {
                map.put(head, new ArrayList<>());
            }
            map.get(head).add(i);
        }
        
        for(int key : map.keySet()) {
            List<Integer> list = map.get(key);
            List<Character> charList = new ArrayList<>();
            
            for(int value : list) {
                charList.add(s.charAt(value));
            }
            
            Collections.sort(charList);
            
            for(int i = 0 ; i < list.size() ; i++) {
                smallest[list.get(i)] = charList.get(i);
            }
        }
        
        return new String(smallest);
    }
    
    public int find(int vertex, int[] tracker) {
        
        while(tracker[vertex] > -1) {
            vertex = tracker[vertex];
        }
        return vertex;
    }
    
    public void union(int head1, int head2, int[] tracker) {
        
        if(head1 != head2) {
            int totalWeight = tracker[head1] + tracker[head2];
            
            if(tracker[head1] <= tracker[head2]) {
                tracker[head2] = head1;
                tracker[head1] = totalWeight;
            }
            else {
                tracker[head1] = head2;
                tracker[head2] = totalWeight;
            }
        }
    } 
}


/*
s = "dcab", pairs = [[0,3],[1,2]]

0--3
 
1--2

0123
dcab

bacd



s = "dcab", pairs = [[0,3],[1,2],[0,2]]


0--3
|
2--1

0123
dcab

acdb


abcd


s = "cba", pairs = [[0,1],[1,2]]

0--1--2

abc



*/