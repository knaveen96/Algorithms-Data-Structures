class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            char currChar = s.charAt(i);
            
            if(stack.size() > 0 && currChar == ')' && stack.peek() == '(') {
                stack.pop();
            }
            else if(stack.size() > 0 && currChar == ']' && stack.peek() == '[') {
                stack.pop();
            }
            else if(stack.size() > 0 && currChar == '}' && stack.peek() == '{') {
                stack.pop();
            }
            else {
                stack.push(currChar);
            }
        }
        return (stack.size() == 0) ? true : false;
    }
}

/*

([])


{(})

}
(
{

*/