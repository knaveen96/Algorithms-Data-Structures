class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] res = new int[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0 ; i < arr.length ; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        } 
        Arrays.sort(arr);
        int index = 0;
        int rank = 1;
        
        while(index < arr.length) {
            List<Integer> list = map.get(arr[index]);
            for(int item : list) {
                res[item] = rank;
            }
            index += list.size();
            rank++;
        }
        return res;
    }
}


/*

  0  1 2 3
[10,10,9,10]

[9,10,10,10]

9,2
10, 0,1,3



*/