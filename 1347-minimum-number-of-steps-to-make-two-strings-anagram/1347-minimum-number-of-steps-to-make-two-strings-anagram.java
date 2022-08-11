class Solution {
public int minSteps(String s, String t) {

    HashMap<Character, Integer> map = new HashMap<>();
    int step=0;
    
    for(char c : s.toCharArray()){
        map.put(c, map.getOrDefault(c, 0)+1);
    }
    
    for(int i=0; i<t.length(); i++){
        char c = t.charAt(i);

        if(map.containsKey(c) && map.get(c)>0){
            map.put(c, map.get(c)-1);
        }
        else step++;
    }
    
    return step;
    }
}


/*


aabc

cdab


leetcode

l 1
e 3 2
t 1 0
c 1 0
o 1 
d 1

practice

p 1
r 1
a 1
c 2
t 1
i 1
e 1

1+1+1+1


s = bab
t = aba

b - 1
a - 0


*/