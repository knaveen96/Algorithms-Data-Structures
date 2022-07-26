class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i = 0 ; i < time.length ; i++) {
            
            if(time[i] % 60 == 0)
                count += map.getOrDefault(0 ,0);
            else
                count += map.getOrDefault(60 - time[i]%60, 0);

            map.put(time[i]%60, map.getOrDefault(time[i]%60 ,0) + 1);
        }
        return count;
    }
}



/*
30 - 1,0
20 - 1,1
150 - 1,2
100 - 1,3
40 - 1,4

60 - 3,2

max = 150

(60*1 - 30) = 30 x
(60*2 - 30) = 90 x
60*3 - 30 = 150 tick





*/


/*

[30,20,150,100,40]
               ^

30 - 2
20 - 1
40 - 1



count = 2


[60,60,60]
       ^

0 - 2

count = 1 + 2 = 3


*/













