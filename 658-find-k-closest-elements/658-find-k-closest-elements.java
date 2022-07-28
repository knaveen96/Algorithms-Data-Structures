//Time : O(N log k + k log k)
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
     
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<>() {
//             @Override
//             public int compare(Integer a, Integer b) {
//                 if(Math.abs(a-x) == Math.abs(b-x)) {
//                     return b - a;
//                 } else {
//                     return Math.abs(b-x) - Math.abs(a-x);
//                 }
//             }
//         });
        
        
//         for(int num : arr) {
//             maxHeap.add(num);
            
//             if(maxHeap.size() > k) {
//                 maxHeap.poll();
//             }
//         }
        
//         List<Integer> res = new ArrayList<>();
        
//         while(maxHeap.size() > 0) {
//             res.add(maxHeap.poll());
//         }
        
//         Collections.sort(res);
//         return res;
//     }
// }



// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
//         int left = 0;
//         int right = arr.length - 1;
//         List<Integer> res = new ArrayList<>();
        
//         while(left < right) {
//             int mid = (left + right) / 2;
//             if(arr[mid] < x) {
//                 left = mid + 1;
//             }
//             else {
//                 right = mid; 
//             }
//         }
                
//         left = left - 1;
//         right = left + 1;
        
//         while(right - left - 1 < k) {
            
//             //if left is at -1 then keep moving only right
//             if(left == -1) {
//                 right = right + 1;
//                 continue;
//             }
            
//             if(right == arr.length || Math.abs(arr[left] - x) <= 
//                             Math.abs(arr[right] - x)) {
//                 left = left - 1;
//             } else {
//                 right = right + 1;
//             }
            
//         }
        
//         for(int i = left + 1 ; i < right ; i++) {
//             res.add(arr[i]);
//         }
//         return res;
//     }
// }


/*
   0 1 2 3 4
  [1,2,3,4,5]   k = 4, x = 3
   l
 
          r

*/


// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
//         List<Integer> res = new ArrayList<>();
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<>() {
//             @Override
//             public int compare(Integer a, Integer b) {
//                 if(Math.abs(a-x) == Math.abs(b-x)) {
//                     return b - a;
//                 } else {
//                     return Math.abs(b-x) - Math.abs(a-x);
//                 }
//             }
//         });
        
//         for(int i = 0 ; i < arr.length ; i++) {
//             maxHeap.add(arr[i]);
//             if(maxHeap.size() > k) {
//                 maxHeap.poll();
//             }
//         }
                
//         while(maxHeap.size() > 0) {
//             res.add(maxHeap.poll());
//         }
        
//         Collections.sort(res);
        
//         return res;
//     }
// }


/*

time : O(N log k) + O(k log k)

arr = [1,2,3,4,5], k = 4, x = 3


 0 1 2 3 4 
[1,2,3,4,5]



low = 0
high = 4

mid = 2

(3-3) = 0

*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > x) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        left = left - 1;
        right = left + 1;
        
        while(right - left - 1 < k) {
            
            if(left == -1) {
                right = right + 1;
            }
            else if(right == arr.length) {
                left = left - 1;
            }
            else if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left = left - 1;
            }
            else {
                right = right + 1;
            }
        }
        
        for(int i = left + 1 ; i < right ; i++) {
            res.add(arr[i]);
        }
        return res;
        
    }
}
























