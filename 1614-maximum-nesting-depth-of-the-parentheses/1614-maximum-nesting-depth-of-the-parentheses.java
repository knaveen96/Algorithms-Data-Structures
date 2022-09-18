class Solution {
    public int maxDepth(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            char curr = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek() == '(' && curr == ')') {
                stack.pop();
            }
            else if(curr == '('){
                stack.push(curr);
            }
            res = Math.max(res, stack.size());
        }
        return res;
    }
}