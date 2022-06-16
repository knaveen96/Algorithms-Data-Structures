class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> stack = new Stack<>();
        
        for(char currChar : num.toCharArray()) {
            
            while(!stack.isEmpty() && k > 0 && stack.peek() > currChar) {
                stack.pop();
                k--;
            }
            stack.push(currChar);
        }
        
        StringBuilder res = new StringBuilder();
        
        while(k-- > 0) {
            stack.pop();
        }
      
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
          
        while(res.length() > 1 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }
        
        return res.length() == 0 ? "0" : res.reverse().toString();
    }
}


/*

"1432219"
     ^
1



2
1


- clearly maintain a monotically increasing stack.

1045 k = 1


10200 k = 1


1243

243
143
123

12453 k = 2

2453
1453
1253
1243 x
1245



3
2
1

1243




*/