class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i <= s.length() - k ; i++) {
            String curr = s.substring(i, i+k);
            set.add(curr);
            if(set.size() == Math.pow(2, k)) return true;
        }
        return false;
    }
}


/*
01234567
00110110


00 01 11 10 -> 2
000 100 010 001 110 011 101 111 -> 3

2^k substrings


Set -> 00, 01, 11,10,

00110110


*/