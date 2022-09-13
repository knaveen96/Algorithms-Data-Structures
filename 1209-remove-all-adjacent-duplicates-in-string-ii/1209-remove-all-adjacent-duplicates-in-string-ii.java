class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        
        for(int i = 0 ; i < s.length() ; i++) {
            char curr = s.charAt(i);
            int count = 1;
            
            if(!stack.isEmpty() && stack.peek().getKey() == curr) {
                count += stack.peek().getValue();
            }
            stack.push(new Pair<>(curr, count));
            int currCount = count;
            
            if(currCount == k) {
                while(currCount-- > 0) {
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()) {
            res.append(stack.pop().getKey());
        }
        
        return res.reverse().toString();
    }
}