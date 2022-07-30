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
class Solution {
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        
        if(dfs(root) == 0) cameras += 1;
        return cameras;
    }
    
    public int dfs(TreeNode root) {
        
        if(root == null) return 1;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if(left == 0 || right == 0) {
            cameras++;
            return 2;
        }
        if(left == 1 && right == 1) {
            return 0;
        }
        if(left == 2 || right == 2) {
            return 1;
        }
        return -1;
    }
    
}


/*


[0,null,0,null,0,null,0]

                        0
                         \
                          0
                           \
                            2
                             \
                              0

[0,0,0,0,0,null,null,0,0,0,0,null,null,null,null,null,null,0]


                 2
              /     \
             0       0
            /\       
           2  2     
          /\  /\    
    0    0 2  0 0  
           /
          0 
          
         
  1 - monitored
  2 - camera
  0 - not monitored
  


*/