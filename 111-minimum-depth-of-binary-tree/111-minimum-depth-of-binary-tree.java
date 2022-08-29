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
//     public int minDepth(TreeNode root) {
        
//         return findMinDepth(root);
        
//     }
    
//     private int findMinDepth(TreeNode root){
//         if(root == null)
//             return 0;
        
//         if(root.left == null && root.right == null)
//             return 1;
            
//         int leftDepth, rightDepth;
//         if(root.left != null)
//             leftDepth = findMinDepth(root.left);
//         else
//             leftDepth = Integer.MAX_VALUE;
        
//         if(root.right != null)
//             rightDepth = findMinDepth(root.right);
//         else
//             rightDepth = Integer.MAX_VALUE;
        
//         return Math.min(leftDepth, rightDepth) + 1;
            
            
//     }
// }


class Solution {
    public int minDepth(TreeNode root) {
        
        return findMin(root);
    }
    
    public int findMin(TreeNode root) {
        
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int left, right;
        
        if(root.left != null)
            left = findMin(root.left);
        else 
            left = Integer.MAX_VALUE;
        
        if(root.right != null)
            right = findMin(root.right);
        else 
            right = Integer.MAX_VALUE;
        
        return Math.min(left, right) + 1;
    }
}





/*


                2
                    3
                        4
                            5
                                6


                      1
                2           3
            4      5     6      7
                 8   9    
                    



*/




















