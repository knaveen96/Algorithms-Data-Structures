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
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    
    public boolean inOrder(TreeNode root) {
        if(root == null) return true;
        
        boolean left = inOrder(root.left);
        if(prev != null && root.val <= prev) return false;
        prev = root.val;
        boolean right = inOrder(root.right);
        
        return left && right;
        
    }
}

/*

            1
        1

                            5
                        3        7
                    1     4    6   9


prev = 4

if(currVal < prev) 
    return false;
prev = currVal



*/