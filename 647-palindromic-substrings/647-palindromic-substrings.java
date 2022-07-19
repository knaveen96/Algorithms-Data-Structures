class Solution {
    public int countSubstrings(String s) {
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        
        for(int g = 0 ; g < s.length() ; g++) {
            for(int i = 0, j = g ; j < s.length() ; i++, j++) {
                
                if(g == 0) dp[i][j] = true;
                
                else if(g == 1) {
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                }
                
                else{
                    if(s.charAt(i) == s.charAt(j) 
                       && dp[i+1][j-1] == true) {
                        
                        dp[i][j] = true;
                    }
                }
                
                if(dp[i][j] == true) count++;
            }
        }
        
        return count;
    }
}


/*
                             aaa
                       a      a       a
                    aa
                    
                    
                    
      0 1 2           
    0 t t 
    1   t t
    2     t
*/