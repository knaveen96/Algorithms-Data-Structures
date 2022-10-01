class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while(left <= right) {
            int mid = left  + (right - left) / 2;
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return -1;
    }
}

/*

 0 1 2 3 4 5 6 7
[0,1,2,3,4,7,5,4]
         l
           m 
               r
    
               
- if increasing go right > >
- if dec go left < <
 
0 1 2 3 4 5 6
0 7 4 3 2 1 0
      ^

*/