// class Solution {
//     public static List<String> letterCombinations(String digits) {
        
//          if (digits.isEmpty()){
//             return new ArrayList<>();
//         }
        
//         Map<Character, String> map = new HashMap<>();
//         map.put('1', "");
//         map.put('2', "abc");
//         map.put('3', "def");
//         map.put('4', "ghi");
//         map.put('5', "jkl");
//         map.put('6', "mno");
//         map.put('7', "pqrs");
//         map.put('8', "tuv");
//         map.put('9', "wxyz");
//         map.put('0', " ");
        
//         StringBuilder prefix = new StringBuilder();
//         List<String> list = new ArrayList<>();
        
//         for(int x = 0; x < digits.length(); x++){
//             list.add(map.get(digits.charAt(x)));
//         }
        
//         List<String> result = new ArrayList<>();
//         return myCombination(list, digits, prefix, result);
//     }
    
//     public static List<String> myCombination(List<String> list,
//                                       String digits,
//                                       StringBuilder prefix,
//                                       List<String> result){
        
//         int digitSize = digits.length();
        
//         if (prefix.length() == digitSize){
            
//             result.add(prefix.toString());
//             return result;
//         }

//         for(int x = 0; x < list.get(0).length(); x++){
            
//             prefix.append(list.get(0).charAt(x));
//             myCombination(list.subList(1, list.size()), digits, prefix, result);
//             prefix.deleteCharAt(prefix.length() - 1);
//         }
//         return result;
//     }
// }



class Solution {
    
    static Map<Character, char[]> map;
    
    public static List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        if(digits.length() == 0 || digits.isEmpty()) return res;
        map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        backtrack(digits, 0, "", res);
        
        return res;
    }
    
    public static void backtrack(String digits, int index, String curr, List<String> res) {
        
        if(digits.length() == curr.length()) {
            res.add(curr);
            return;
        }
        
        for(char c : map.get(digits.charAt(index))) {
            curr += c;
            backtrack(digits, index + 1, curr, res);
            StringBuilder sb = new StringBuilder(curr);
            sb.deleteCharAt(curr.length() - 1);
            curr = sb.toString();
        }
                
    }
}


/*
                         ^
                        23
                         2
                 a       b      c
            ad  ae  af  
                    



*/













