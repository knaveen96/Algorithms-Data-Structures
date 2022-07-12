// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
        
//         int[] char_counts = new int[26];
        
//         if(s1.length() > s2.length() || s1 == null || s2 == null) 
//             return false;
        
//         for(char c : s1.toCharArray()) 
//             char_counts[c - 'a']++;
        
//         int right = 0;
//         int left = 0;
//         int count = s1.length();
        
//         while(right < s2.length()) {
                
//             if(char_counts[s2.charAt(right++) - 'a']-- >= 1) count--;
            
//             if(count == 0) return true;
            
//             if(right - left == s1.length() && 
//                             char_counts[s2.charAt(left++) - 'a']++ >= 0)
//                 count++;
//         }
        
//         return false;
//     }
// }


/*

s1 = "ab", s2 = "eidbaooo"

[1,1,0,0,0...]

eidbaooo
     l
      r
 
count = 0

if(count == 0) true



*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Map<Character, Integer> map = new HashMap<>();
        int count = s1.length();
        int left = 0, right = 0;
        
        for(char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        while(right < s2.length()) {
            
            char rightChar = s2.charAt(right);
            
            if(map.containsKey(rightChar)) {
                if(map.get(rightChar) > 0) {
                    count--;
                }
                int val = map.get(rightChar);
                map.put(rightChar, val - 1);
            }
            
            if(count == 0) {
                return true;
            }
            
            if(right - left + 1 == s1.length()) {
                char leftChar = s2.charAt(left);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) >= 0) {
                        count++;
                    }
                    int val = map.get(leftChar);
                    map.put(leftChar, val + 1);
                }
                left++;
            }
            right++;
        }        
        return false;
    }
}


/*
s1 = "ab" s2 = "eidboaoo"

ab
a - 1
b - 1

count = 

eidboaoo




"adc"
dcda
l
  r

count = 2

a - 1
d - 0
c - 0





s1 = "abb", s2 = "eidbabooo"
true


a - 1
b - 2

eidbabooo
   l
     r


s1 = "abb", s2 = "eidbaobo"
false


*/




















