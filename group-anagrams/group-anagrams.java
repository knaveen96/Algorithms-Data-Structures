class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        int[] freq = new int[26];
        
        for(String s : strs) {
            Arrays.fill(freq, 0);
            
            for(char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder("");
            
            for(int i = 0 ; i < 26 ; i++) {
                sb.append('$');
                sb.append(freq[i]);
            }
            String find = sb.toString();
            
            if(map.containsKey(find)) {
                map.get(find).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(find, list);
            }            
        }
        return new ArrayList<>(map.values());
    }
}