// class Solution {
//     public int shipWithinDays(int[] weights, int days) {
        
//         //List<Integer> shipping = new ArrayList<>();
//         int sumTillNow = 0; 
//         int avg = 0;
//         int total = 0;
//         int res = Integer.MIN_VALUE;
        
//         for(int i = 0 ; i < weights.length ; i++) total += weights[i];
        
//         if(days == 1) return total;
//         avg = total / days;
        
//         for(int i = 0 ; i < weights.length ; i++) {
            
//             if(sumTillNow < avg)
//                 sumTillNow += weights[i];
//             else {
//                 res = Math.max(res, sumTillNow);
//                 total = total - sumTillNow;
//                 days--;
//                 if(days != 0) avg = total / days;                
//             }
//         }
//         return res;  
//     }
// }

// class Solution {
//     public int shipWithinDays(int[] weights, int days) {
        
//         int left = Integer.MIN_VALUE;
//         int right = 0;
        
//         for(int i = 0 ; i < weights.length ; i++) {
//             left = Math.max(left, weights[i]);
//             right += weights[i];
//         }
        
//         while(left < right) {
//             int mid = (left + right) / 2;
            
//             if(canShip(mid, weights, days)) {
//                 right = mid;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return right;
//     }
    
//     private boolean canShip(int maxWeight, int[] weights, int days) {
        
//         int currWeight = 0;
//         int daysTaken = 1;
        
//         for(int weight : weights) {
//             currWeight += weight;
            
//             if(currWeight > maxWeight) {
//                 daysTaken++;
//                 currWeight = weight;
//             }
//         }
        
//         return daysTaken <= days;
//     }
// }

/*


[1,2,3,4,5,6,7,8,9,10]
days = 5

min that I can ship is 10 which is the max in the array.
max that I can ship is 55 which is the sum of the array

10..    32     ..55


*/


class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        //if(days == 0) return 0;
        int low = Integer.MIN_VALUE, high = 0;
        int res = 0;
        
        for(int wt : weights) {
            high += wt;
            low = Math.max(low, wt);
        }
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(canShip(mid, weights, days)) {
                high = mid - 1;
                res = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return res;
    }
    
    public boolean canShip(int maxWeight, int[] weights, int days) {
        int k = 0;
        int currWeight = 0;
        
        for(int i = 0 ; i < weights.length ; i++) {
            currWeight += weights[i];
            
            if(currWeight > maxWeight) {
                k++;
                currWeight = weights[i];
            }
        }
        k++;
        return k <= days;
    }
}


/*

weights = [1,2,3,4,5,6,7,8,9,10], days = 5

[1,2,3,4,5,6,7,8,9,10]

- I have to send at least max(weights)


low = 10 
high = 55


mid = 32

28, 27











 0 1 2 3 4 5 6 7 8 9
[1,2,3,4,5,6,7,8,9,10]
 ^
           ^

days = 5

55 
avg = 55 / 5 = 11

40/5 = 8
27 / 3 = 9

[3,2,2,4,1,4]
         ^
days = 3

avg = 16 / 3 = 5
avg = 10 / 2 = 5
avg = 5 / 1 = 5




leastWeight = 55
minDays = 3

55 / 2 = 27 / 2 = 13 / 2 = 

13,13,13,13

*/