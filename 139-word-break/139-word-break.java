//Recursive
// public class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         return wordBreakRecur(s, new HashSet<>(wordDict), 0);
//     }

//     private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
//         if (start == s.length()) {
//             return true;
//         }
//         for (int end = start + 1; end <= s.length(); end++) {
            
//             if (wordDict.contains(s.substring(start, end)) &&                                       wordBreakRecur(s, wordDict, end)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }


// public class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
        
        
//         int n = s.length();
//         boolean[] dp = new boolean[s.length() + 1];
//         dp[0] = true;
        
//         for(int i = 1; i <= s.length() ; i++) {
//             for(int j = 0 ; j < i ; j++) {
                
//                 if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    
//                     dp[i] = true;
//                     break;
//                 }
                    
//             }
//         }
    
//         return dp[n];
//     }
// }



//Example : LEETCODE
//LEET, LEETC, ODE





// public class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         Set<String> set = new HashSet<>(wordDict);
//         Boolean[] memo = new Boolean[s.length()];
//         return canBreakWord(s, set, 0, memo);
        
//     }
    
//     private boolean canBreakWord(String s, Set<String> set, int start, Boolean[] memo) {
        
//         if(start == s.length()) return true;
        
//         if(memo[start] != null) return memo[start];
        
//         for(int end = start + 1 ; end <= s.length() ; end++) {
//             if(set.contains(s.substring(start, end))) {
//                 if(canBreakWord(s, set, end, memo)) {
//                     return true;
//                 }
//             }
//         }
//         return memo[start] = false;
//     }
// }





/*

wordDict = ["apple","pen"]

0123456789101112
applepenap p l e
^







*/


public class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> words = new HashSet<>();
        memo = new Boolean[s.length()];
        for(String word: wordDict) words.add(word);
        return canPartition(s, words, 0);

    }
    
    public boolean canPartition(String s, Set<String> words, int start) {
        
        if(start == s.length()) return true;
        
        if(memo[start] != null) return memo[start];
        
        for(int i = start+1 ; i <= s.length() ; i++) {
            if(words.contains(s.substring(start, i))) {
                if(canPartition(s, words, i)) return true;
            }
        }
        return memo[start] = false;
    }
}




/*


01234567
leetcode
    ^
       ^

wordDict = ["leet","code"]




*/

















