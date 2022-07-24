class Solution {
    public int maxLength(int[] ribbons, int k) {
        
        int left = 1;
        int right = Arrays.stream(ribbons).max().getAsInt();
        int res = 0;
        
        while(left <= right) {
            
            int mid = (left + right) / 2;
            
            if(canCut(ribbons, k, mid)) {
                left = mid + 1;
                res = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return res;
    }
    
    private boolean canCut(int[] ribbons, int k, int length) {
        
        int count = 0;
        for(int ribbon : ribbons) 
            count += ribbon / length;
        
        return count >= k;
    }
}



/*

ribbons = [7,5,9], k = 4


[1,2,3,4] 
       l
       m
       r


max size that can have is 9.
min size is 1.

 

*/


// class Solution {
//     public int maxLength(int[] ribbons, int k) {
        
//     }
// }



/*





*/
































