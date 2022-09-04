class Solution {
    public int candy(int[] ratings) {
        
        int n = ratings.length;
        if(n == 0) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int count = 0;
        
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        for(int i = 1 ; i < n ; i++) {
            if(ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        
        for(int i = n - 2 ; i >= 0 ; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        
        for(int i = 0 ; i < n ; i++) {
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}


/*

[1,0,0,3,2]
 2 1 1 2 1
 
 0 1 2 3 4  5 6 
[5,4,3,2,1, 2,3]   -> 20
 1 1 1 1 1  1 1
 
 maxCandies = 1
 count = 17
 
[5,4,3,4,5,1]
 3 2 1 2 3 1
 
[1,1,1,2,3,1]

[3,2,1,1,1,1]
 
 curr > prev -> update
 
 mc = 3
 count = 11
 


5 
 
 
 mc = 2
count = 7


[5,4,3,2,3]


mc = 0
count = 10 







 


*/