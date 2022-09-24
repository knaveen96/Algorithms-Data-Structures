class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int i = 0;
        char prev = '+';
        
        while(i < s.length()) {
            char curr = s.charAt(i);
            if(curr == ' ') {
                i++;
                continue;
            }
            int num = 0;
            if(Character.isDigit(curr)) {
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                if(prev == '+') {
                    stack.push(num);
                }
                else if(prev == '-') {
                    stack.push(-1 * num);
                }
                else if(prev == '*') {
                    stack.push(stack.pop() * num);
                }
                else if(prev == '/') {
                    stack.push(stack.pop() / num);
                }
            }
            else {
                prev = curr;
            }
            i++;
        }
        
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}

/*
33-2*2/2+2 
 ^

-2
33

prev = -

- if the curr is an integer push the value 
    stack.push(sign * currInt)


*/