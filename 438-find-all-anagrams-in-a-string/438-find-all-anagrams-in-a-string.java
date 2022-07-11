class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int count = 0;
        
        for(char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
            sMap.put(c, 0);
        }

        while(right < s.length()) {
            
            char rightChar = s.charAt(right); 
            if(sMap.containsKey(rightChar)) {
                if(sMap.get(rightChar) < pMap.get(rightChar)) {
                    count++; 
                }
                sMap.put(rightChar, sMap.getOrDefault(rightChar, 0) + 1);
            }
            
            if(count == p.length()) {
                res.add(left);
            }
            
            if(right - left + 1 == p.length()) {
                
                char leftChar = s.charAt(left);
                if(sMap.containsKey(leftChar)) {
                    int cnt = sMap.get(leftChar);
                    if(sMap.get(leftChar) <= pMap.get(leftChar)) {
                        count--;
                    }
                    sMap.put(leftChar, cnt - 1);
                }
                left++;
            }
            right++;            
        }
        return res;
    }
}
