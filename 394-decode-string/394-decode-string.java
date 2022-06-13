class Solution {
    public String decodeString(String s) {
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < s.length() ; i++) {
            
            if(s.charAt(i) == ']') {
                List<Character> list = new ArrayList<>();
                while(stack.peek() != '[') {
                    list.add(stack.pop());
                }
                stack.pop();
                
                int k = 0;
                int base = 1;
                while(!stack.isEmpty() &&                                                                  Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0')*base;
                    base = base*10;
                }
                
                while(k > 0) {
                    for(int j = list.size() - 1 ; j >=0 ; j--) {
                        stack.push(list.get(j));
                    }
                    k--;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        char[] res = new char[stack.size()];
        for(int i = res.length - 1 ; i >= 0 ; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}


//Using 2 stacks
// class Solution {
//     public String decodeString(String s) {
        
//         Stack<Integer> counts = new Stack<>();
//         Stack<String> result = new Stack<>();
//         String res = "";
//         int index = 0;
        
//         while(index < s.length()) {
            
//             if(Character.isDigit(s.charAt(index))) {
//                 int val = 0;
//                 while(Character.isDigit(s.charAt(index))) {
//                     val = val * 10 + (s.charAt(index) - '0');
//                     index++;
//                 }
//                 counts.push(val);
//             }
//             else if(s.charAt(index) == '[') {
//                 result.push(res);
//                 res = "";
//                 index++;
//             }
//             else if(s.charAt(index) == ']') {
//                 StringBuilder temp = new StringBuilder(result.pop());
//                 int count = counts.pop();
//                 for(int i = 0 ; i < count ; i++) {
//                     temp.append(res);
//                 }
//                 res = temp.toString();
//                 index++;
//             }
//             else {
//                 res += s.charAt(index);
//                 index++;
//             }
//         }
//         return res;
//     }
// }


/*


3[a2[c]]

StringBuilder = acc     aaa       abcabccdcdcd
stack->


"2[abc]3[cd]ef"
              ^
*/ 



// class Solution {
//     public String decodeString(String s) { //  3[a2[c]] 
//                                           //         ^ 
    
//         Stack<Character> stack = new Stack<>(); //  3 [ a c 
//         int index = 0; 
        
//         while(index < s.length()) { 
            
//             if(Character.isDigit(s.charAt(index))) { 
//                 int num = 0; //0
//                 while(Character.isDigit(s.charAt(index))) {
//                     num = num*10 + (s.charAt(index++) - '0');
//                 }
//                 stack.push((char) num);
//                 continue;
//             }
            
//             if(s.charAt(index) == ']') {
//                 List<Character> decodedString = new ArrayList<>();
//                 while (stack.peek() != '[') {
//                     decodedString.add(stack.pop());
//                 }
//                 stack.pop();
//                 int base = 1;
//                 int k = 0;

//                 while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
//                     k = k + (stack.pop() - '0') * base;
//                     base *= 10;
//                 }
//                 while (k != 0) {
//                     for (int j = decodedString.size() - 1; j >= 0; j--) {
//                         stack.push(decodedString.get(j));
//                     }
//                     k--;
//                 }
//             }
//             else {
//                 stack.push(s.charAt(index));
//             }
//             index++;
//         }
        
//         char[] result = new char[stack.size()];
//         for (int i = result.length - 1; i >= 0; i--) {
//             result[i] = stack.pop();
//         }
        
//         return new String(result);
//     }
// }




/*
 s = "3[a2[bc]]" ->  abcbc abcbc abcbc
 
3 [ a 2 [ b c ] ] 
            ^

cbcb
            
stack ->

c
b
c
b
a
[ 
3 

cbcba cbcba cbcba 

abcbc

if(currChar == ']') {
    
    while(stack.peek() != '[') //until I hit a [ keep appending the popped chars
        cb  , a
         
    
    if(Character.isDigit(stack.peek())) { //2
        //repeat the sequence for popped number of times
        cbcb
    }
    
    //add back to the stack in rev order.
    
}
 
 
 


*/

