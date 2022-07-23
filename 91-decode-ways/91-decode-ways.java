// class Solution {
    
//     Map<Integer, Integer> map = new HashMap<>();
    
//     public int numDecodings(String s) {
        
//         return countDecodings(s, 0);
//     }
    
//     private int countDecodings(String s, int index) {
        
//         if(index == s.length()) return 1;
        
//         if(map.containsKey(index)) return map.get(index);
        
//         if(s.charAt(index) == '0') return 0;
        
//         if(index == s.length() - 1) return 1;
        
//         int count = 0;
        
//         count += countDecodings(s, index + 1);
        
//         if(Integer.parseInt(s.substring(index, index + 2)) < 27) {
//             count += countDecodings(s, index + 2);
//         } 
        
//         map.put(index, count);
//         return count;
//     }
// }


//Iterative
// class Solution {
//     public int numDecodings(String s) {
        
//         int[] dp = new int[s.length() + 1];
//         dp[0] = 1;
//         dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
//         for(int i = 2 ; i < dp.length ; i++) {
            
//             int x = Integer.valueOf(s.substring(i - 1, i));
//             if(x >= 1) dp[i] = dp[i - 1];
//             int y = Integer.valueOf(s.substring(i - 2, i));
//             if(y >= 10 && y <= 26) dp[i] += dp[i - 2];
//         }
        
//         return dp[s.length()];
//     }
// }


/*

 1221 - 5
   ^ 
                1221
             1       12
          2     22  2
         2 21  1
        1
        
        
[0,0,0,0,0];

    

*/




class Solution {    
    Map<Integer, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        return totalDecodes(s, 0);
    }
    
    public int totalDecodes(String s, int index) {
        
        if(index == s.length()) return 1;
        if(map.containsKey(index)) return map.get(index);
        if(s.charAt(index) == '0') return 0;
        if(index == s.length() - 1) return 1;
        
        int count = 0;
        
        count += totalDecodes(s, index + 1);
        
        int value2 = Integer.valueOf(s.substring(index, index + 2));
        if(value2 < 27) {
            count += totalDecodes(s, index + 2);
        }
        
        map.put(index, count);
        
        return count;
    }
}




/*
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"

           0123
            220
       2 29            
            


               0123
                226 
        2 26         22 6
    2 2 6  2 26
                
                
                
                
                
                
- start digit should not be 0
- split value should lie b/w 1 and 26

 



*/




















