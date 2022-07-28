// class Solution {
//     public List<String> generateParenthesis(int n) {
       
//         List<String> list = new ArrayList<>();
//         backTrackParentheses(list, "", 0, 0, n);
//         return list;
//     }
    
//     public void backTrackParentheses(List<String> list, String res, int open, int close, int n){
            
//         if(res.length() == n*2){
            
//             list.add(res);
//             return;
//         }
        
//         if(open < n){
//             backTrackParentheses(list, res+"(", open+1, close, n);
//         }
        
//         if(close < open){
//             backTrackParentheses(list, res+")", open, close+1, n);
//         }
//     }
    
// }

/*

n = 3

close = 2
open = 0

                    (((  )))
                        (  
               ((                  ()
          (((       (()
    ((()))       (()(  (())
              (()())  
                






*/

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, "");
        return res;
    }
    
    public void backtrack(int n, int open, int close, String curr) {
        
        if(curr.length() == 2 * n) {
            res.add(curr);
            return;
        }
        if(open == n) {
            while(close++ < n) {
                curr += ')';
            }
            res.add(curr);
            return;
        }
        
        if(open < n) {
            backtrack(n, open + 1, close, curr + "(");
        }
        if(close < open) {
            backtrack(n, open, close + 1, curr + ")");
        }
    }
}

























