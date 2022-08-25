/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return findLCA(root, p, q);
    }
    
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p.val < root.val && q.val < root.val) {
            return findLCA(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val) {
            return findLCA(root.right, p, q);
        }
        return root;
    }
}

/*

- if both p,q are greater than the root val then go right
- if both p,q are less than the root val then go left
- if lies b/w both then return that TreeNode

*/