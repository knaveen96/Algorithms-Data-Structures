class OrderedStream {
    int ptr;
    String[] arr;
    public OrderedStream(int n) {
        ptr = 1;
        arr = new String[n + 1];
    }
    
    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> list = new ArrayList<>();
        
        while(ptr < arr.length && arr[ptr] != null) {
            list.add(arr[ptr++]);
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