class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int left = 0;
        int totalSum = 0;
        int winSize = cardPoints.length - k;
        int presentSubarrayScore = 0;

        for(int i = 0 ; i < cardPoints.length ; i++) 
            totalSum += cardPoints[i];
        
        int minSubarrayScore = totalSum;
        
         if (k == cardPoints.length) {
             return totalSum;
        }
        
        for(int i = 0 ; i < cardPoints.length ; i++) {
            
            presentSubarrayScore += cardPoints[i]; 
            
            if(winSize == i - left + 1) {
                minSubarrayScore = Math.min(minSubarrayScore,                                                           presentSubarrayScore);
                
                presentSubarrayScore -= cardPoints[left++];
            }
        }
        
        return totalSum - minSubarrayScore;
    }
}


/*
[1,2,3,4,5,6,1] k = 3
 l     r

sum = 12 - 5 +1 = 8-6+2 = 4+3 -1= 6

12 9 9 15

res = Math.max(res, sum)

*/
