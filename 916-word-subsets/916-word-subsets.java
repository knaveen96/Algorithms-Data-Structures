class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> res = new ArrayList<>();
        if(words1.length == 0 || words2.length == 0) return res;
        
        int[] maxFreq = new int[26];
        
        for(String word : words2) {
            int[] freq = findFreq(word);
            
            for(int i = 0 ; i < 26 ; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        
        for(String word : words1) {
            int[] freq = findFreq(word);
            
            boolean valid = true;
            for(int i = 0 ; i < 26 ; i++) {
                if(freq[i] < maxFreq[i]) {
                    valid = false;
                    break;
                }
            }
            if(valid) res.add(word);
        }        
        return res;
    }
    
    public int[] findFreq(String word) {
        int[] currWordFreq = new int[26];
        
        for(char c : word.toCharArray()) {
            currWordFreq[c - 'a']++;
        }
        return currWordFreq;
    }
}

/*

["amazon","apple","facebook","google","leetcode"]
["lo","eo"]

lo eo

l 1
o 1
e 1

a 2 
m 1 
z 1
o 1
n 1








*/