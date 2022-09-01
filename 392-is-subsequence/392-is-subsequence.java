// class Solution {
//     public boolean isSubsequence(String s, String t) {
        
//         HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
//         int num = 1;
//         int[] arr = new int[s.length()];
//         int i = 0;

//         for(char c : t.toCharArray()){
//             if(!map.containsKey(c)){
//                 ArrayList<Integer> indices = new ArrayList<Integer>();
//                 indices.add(num);                
//                 map.put(c, indices);
//             }
                
//             else{
//                 ArrayList<Integer> arrList = new ArrayList<>();
//                 map.get(c).add(num);
//             }

//             num++;
//         }
        
//         Integer currMatchIndex = -1;
//         for (char letter : s.toCharArray()) {
            
//             if (!map.containsKey(letter))
//                 return false;

//             boolean isMatched = false;

//             for (Integer matchIndex : map.get(letter)) {
//                 if (currMatchIndex < matchIndex) {
//                     currMatchIndex = matchIndex;
//                     isMatched = true;
//                     break;
//                 }
//             }

//             if (!isMatched)
//                 return false;
//         }

//         return true;
//     }
// }

// "abc"
// "ahbgdc"

// a 1
// h 2
// b 3
// g 4
// d 5
// c 6



/*

s = "abc"
t = "ahbgdc"

012345
ahbgdc
^ 



abc
  ^




*/


class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int sp = 0;
        int tp = 0;
        
        if(t.length() < s.length()) return false;
        
        while(sp < s.length() && tp < t.length()) {
            
            char tChar = t.charAt(tp);
            char sChar = s.charAt(sp);
            
            if(tChar == sChar) {
                tp++;
                sp++;
            }
            else if(tChar != sChar) {
                tp++;
            }
            
        }
        return sp == s.length();
        
    }
}


/*

aa
^

zz
  ^

*/









