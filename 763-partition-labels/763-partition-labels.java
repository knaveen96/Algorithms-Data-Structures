class Solution {
    public List<Integer> partitionLabels(String s) {
        
        Stack<Integer> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            char currChar = s.charAt(i);
            
            while(!stack.isEmpty() && map.containsKey(currChar) && 
                    stack.peek() >= map.get(currChar)) {
                stack.pop();
            }
            
            if(!map.containsKey(currChar)) {
                map.put(currChar, i + 1);
            }
            
            stack.push(i + 1);
        }
        
        int[] arr = new int[stack.size()];
        int j = stack.size() - 1;
         
        while(stack.size() > 0) {
            arr[j--] = stack.pop();
        }
        
        for(int i = 0 ; i < arr.length ; i++) {
            if(i == 0) {
                res.add(arr[i]);
            } else {
                res.add(arr[i] - arr[i - 1]);
            }
        }
        
        return res;
    }
}

/*
23
15
8

1
0

ababcbaca defegde hijhklij


ababcbaca defegd ehijhklij




10
9


a-0
b-1
c-4

d-9
e-10


0 to 23

a
b
c

d
e
f
g

h
i
j
k
l


 

*/