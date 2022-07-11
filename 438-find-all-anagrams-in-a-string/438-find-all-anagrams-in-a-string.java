// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
        
//         List<Integer> res = new ArrayList<>();
        
//         if(s.length() < p.length()) return res;
//         if(s.length() == 0 || s == null) return res;
        
//         int[] char_counts = new int[26];
        
//         for(char c : p.toCharArray()) 
//             char_counts[c - 'a']++;
        
//         int right = 0;
//         int left = 0;
//         int count = p.length();
        
//         while(right < s.length()) {
            
//             if(char_counts[s.charAt(right++) - 'a']-- >= 1) 
//                 count--;
            
//             if(count == 0) res.add(left);
            
//             if(right - left == p.length() && 
//                             char_counts[s.charAt(left++) - 'a']++ >= 0) 
//                 count++;

//         }
        
//         return res;
//     }
// }


/*

s = "cbaebabacd", p = "abc"

a-1 0
b-1 
c-1 0

cbaebabacd
      ^
        ^
*/




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


/*
s = "cbaebabacd", p = "abc"

0123456789
cbaebabacd
l
   r


a - 0
b - 0
c - 0

count = 3

a - 1
b - 1
c - 0









a - 1
b - 1
c - 0

p.length() = 3
so, count should be equal to p.length()

a - 1
b - 1
c - 1


s = "abab", p = "ab"

0123
abab


012345678
abcabcabc      abc
  l
   r


[0,1,2,3,4,5,6]
[0,1]

a - 1
b - 1
c - 1


a - 1
b - 1
c - 1



- whenever the window size is greater than p.length() then start moving left.

- one there is a valid window update the res.
- move left until the window again becomes invalid.
- when right is ++ if the window is not valid, the 





*/