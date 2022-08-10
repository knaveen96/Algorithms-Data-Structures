class Solution {
    public int minFlips(String target) {
        
        char state = '0';
        int flips = 0;
        
        for(int i = 0 ; i < target.length() ; i++) {
            if(state != target.charAt(i)) {
                flips++;
                state = (state == '0') ? '1' : '0';
            }
        }
        return flips;
    }
}

/*
- try going greedy from 0th index.        
                
            
            


*/