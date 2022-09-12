class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> res = new ArrayList<>();
        
        for(String curr : words) {
            if(same(curr, pattern)) {
                res.add(curr);
            }
        }
        return res;
    }
    
    public boolean same(String curr, String pattern) {
        Map<Character, Character> map = new HashMap<>();
            for(int i = 0 ; i < curr.length() ; i++) { //2
                char c1 = curr.charAt(i); // c
                char c2 = pattern.charAt(i); //b
                
                if(!map.containsKey(c1)) 
                    map.put(c1, c2);  
                else{
                    if(map.get(c1) != c2) {
                        return false;
                    }
                }
                boolean[] arr = new boolean[26];

                for(char key : map.keySet()) {
                    if(arr[map.get(key) - 'a']) 
                            return false; 
                    else arr[map.get(key) - 'a'] = true;
                }
            }
        return true;
        }
        
    }


/*
words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"

abb

mee


e-b



*/