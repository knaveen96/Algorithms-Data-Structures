class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        Map<String, Integer> res = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int max = 0;
        
        while(right < s.length()) {
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while(map.size() > maxLetters || right - left + 1 > maxSize) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            while(map.size() <= maxLetters && right - left + 1 >= minSize 
               && right - left + 1 <= maxSize) {
                String str = s.substring(left, right + 1);
                res.put(str, res.getOrDefault(str ,0) + 1);
                System.out.println(str);
                max = Math.max(max, res.get(str));
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            right++;
        }
        for(String key : res.keySet()) {
            System.out.println(key + " " + res.get(key));
        }
        return max;
    }
}


/*
s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4

3 < sub string len < 4


[aab -2, aaba, aabab, bc, ca, caa, aab]

012345678
aababcaab
l
  r
        

a-2
b-1

012345
aaaaaa
 l
   r



*/