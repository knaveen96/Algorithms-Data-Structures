class OrderedStream {
    int ptr;
    Map<Integer, String> map;
    public OrderedStream(int n) {
        ptr = 1;
        map = new HashMap<>();
    }
    
    public List<String> insert(int idKey, String value) {
        map.put(idKey, value);
        List<String> list = new ArrayList<>();
        
        while(map.containsKey(ptr)) {
            list.add(map.get(ptr));
            map.remove(ptr);
            ptr++;
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */



/*

5, e
int ptr = 4

[3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]


a b c



*/