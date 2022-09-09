class Solution {
    public int totalFruit(int[] fruits) {
        
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        while(right < fruits.length) {
            int curr = fruits[right];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            
            while(map.size() > 2) {
                int leftVal = fruits[left];
                map.put(leftVal, map.get(leftVal) - 1);
                if(map.get(leftVal) == 0) {
                    map.remove(leftVal);
                }
                left++;
            }
            
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}

/*

- the window should hold only 2 unique values.

 0 1 2 3 4
[1,2,3,2,2]
 l
 r


map
1-2
3-1

1122113
    l
       r

- move left until the size of the map becomes 2

*/