// class Solution {
    
//     class Node {
//         int val;
//         int index;
        
//         public Node(int val, int index) {
//             this.val = val;
//             this.index = index;
//         }
//     }
    
//     public int[] maxSlidingWindow(int[] nums, int k) {
        
//         PriorityQueue<Node> queue = new PriorityQueue<>(
//             (node1, node2) -> node2.val - node1.val);
        
//         int[] res = new int[nums.length - k + 1];
//         int left = 0;
//         int right = 0;
        
//        while(right < nums.length){

//            if(right-left < k){
//                 queue.add(new Node(nums[right], right));
//                 right++;
//             } 

//            if(right-left == k) {
//                 res[left++] = queue.peek().val;
//             }

//            while(!queue.isEmpty() && queue.peek().index < left){
//                 queue.poll();
//             }
//         }
        
//         return res;
//     }
// }


//Using Deque
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
        
//         Deque<Integer> deque = new ArrayDeque<>();
//         int N = nums.length;
//         int[] res = new int[N - k + 1];
        
//         for(int i = 0 ; i < N ; i++) {
            
//             while(deque.size() > 0 && deque.peekFirst() <= i-k) {
//                 deque.pollFirst();
//             }
            
//             while(deque.size() > 0 && nums[deque.peekLast()] < nums[i]) { 
//                 deque.pollLast();
//             }
            
//             deque.offerLast(i);
            
//             if(i >= k - 1) {
//                 res[i-k+1] = nums[deque.peekFirst()];
//             }
//         }
        
//         return res;
        
//     }
// }






/*

 0 1  2  3 4 5 6 7
[1,3,-1,-3,5,3,6,7], k = 3
 ^    ^
 
res = [3,3,5,5,6,7]
max = 7
queue ->  -1 -3
left = 3;

for(int i = 3 ; i < nums.length ; i++) {
    int rm = queue.remove();
    max = Math.max(max, rm);
    res[i] = max;
    if(max == nums[left]) {
        max = queue.peek();
    }
    queue.add(nums[i]);
    left++;
}


0 1  2  3 4 5 6 7
1 3 -1 -3 5 3 6 7
              ^

[3,3,5,5,6,]
0 <= -2

  6



*/





class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int left = 0, right = 0;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;
        
        while(right < n) {
            
            //expand window
            while(dq.size() > 0 && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }
            dq.addLast(right);
            
            //when the window hits a sweet spot
            //contract window 
            if(right - left + 1 == k) {
                res[index++] = nums[dq.peekFirst()];
                if(dq.peekFirst() == left) {
                    dq.pollFirst();
                }
                left++;
            }
                        
            right++;
        }
        
        return res;
    }
}



/*

nums = [1,3,-1,-3,5,3,6,7], k = 3

 0 1  2  3 4 5 6 7
[1,3,-1,-3,5,3,6,7]
   l
           r
 
 L   F
 3 2 1 
 
[3,3,]


- tarwata ekuva values chuste 
    - while() delete the lesser values.
- tarwata takkkuva values chuste
    - add them to the last
*/















