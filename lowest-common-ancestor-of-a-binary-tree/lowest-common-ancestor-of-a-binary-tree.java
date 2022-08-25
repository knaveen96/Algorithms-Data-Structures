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
    TreeNode res = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return res;
    }
    
    public int findLCA(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return 0;
        
        int left = findLCA(root.left, p, q);
        int right = findLCA(root.right, p, q);
        
        System.out.println(root.val + " " + left + " " + right);
        
        if(left == 1 && right == 1) {
            res = root;
            return 1;
        }
        else if((left == 1 || right == 1) && (root.val == p.val || root.val == q.val)) {
            res = root;
            return 1;
        }
        else if(left == 1 || right == 1) {
            return 1;
        }
        else if(root.val == p.val || root.val == q.val) {
            //System.out.println(root.val + " " + p.val + " " + q.val);
            return 1;
        } 
        return 0;
    }
}

/*
6 0 0
7 0 0
4 0 0
2 0 1

5 0 0
0 0 0
8 0 0
1 0 0
3 1 0

- postorder
- left = 1, right = 1
    return root
- if left = 1, right = 0
    root.val matches
    return root
- if left = 0, right = 1
    root.val matches
    return root

*/