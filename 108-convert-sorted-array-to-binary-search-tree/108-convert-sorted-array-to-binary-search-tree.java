/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {

//         if(nums.length == 0 || nums == null) return null;
//         return constructBST(nums, 0, nums.length - 1);
       
//     }

//     private TreeNode constructBST(int[] nums, int left, int right) {
          
//         if(left > right)
//             return null;
        
//         int mid = left + (right - left) / 2;
//         TreeNode current = new TreeNode(nums[mid]);
        
//         current.left = constructBST(nums, left, mid -1);
//         current.right = constructBST(nums, mid+1, right);
        
//         return current;
//     }
        
// }

//

/**
  0  1  2 3 4
[-10,-3,0,5,9]
        ^
        
    helper(0,4)
    p=2
    root = 0
    
   root.left  = helper(left, p-1); //(0,1)
    p=0
    root= -10
    
    root.left = helper(0, -1);
    
    
   root.right = helper();
    


**/



// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {
        
//         if(nums.length == 0 || nums == null) return null;
//         return constructBST(nums, 0, nums.length - 1);
//     }
    
//     public TreeNode constructBST(int[] nums, int left, int right) {
        
//         if(left > right) return null;
        
//         int mid = left + (right - left) / 2;
//         TreeNode newNode = new TreeNode(nums[mid]);
        
//         newNode.left = constructBST(nums, left, mid - 1);
//         newNode.right = constructBST(nums, mid + 1, right);
        
//         return newNode;
//     }
// }




class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return constructBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode constructBST(int[] nums, int left, int right) {
        
        //base?
        if(left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        
        newNode.left = constructBST(nums, left, mid - 1);
        newNode.right = constructBST(nums, mid + 1, right);
        
        return newNode;
    }
}



/*

   0  1 2 3 4
[-10,-3,0,5,9]

mid = 2











                    0
                  /
                -10
                

   0   1 2 3 4
 [-10,-3,0,5,9] 
         ^
 
 left = 0
 right = 4
 
 mid = 2
 
 0.left = helper(0, 1)
 
 mid = 
 
   0   1
 [-10,-3]
 
 mid = 0
 
 10.left = helper(0, -1)
 
 

*/





