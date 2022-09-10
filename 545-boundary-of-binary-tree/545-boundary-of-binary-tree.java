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
    List<Integer> res;
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        res = new ArrayList<>();
        if(root == null) return res;
        
        res.add(root.val);
        if(isLeaf(root)) return res;
        if(root.left != null) leftBoundary(root.left);
        leaves(root);
        int left = res.size() - 1;
        if(root.right != null) rightBoundary(root.right);
        left++;
        int right = res.size() - 1;
        
        while(left <= right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
        
        return res;
    }
    
    public boolean isLeaf(TreeNode root) {
        
        if(root.left == null && root.right == null) return true;
        return false;
    }
    
    public void leftBoundary(TreeNode node) {
        
        if(node == null || isLeaf(node)) return;
        
        res.add(node.val);
        if(node.left != null) {
            leftBoundary(node.left);
        }
        else {
            leftBoundary(node.right);
        }
    }
    
    public void rightBoundary(TreeNode node) {
        
        if(node == null || isLeaf(node)) return;
        
        System.out.println(node.val);
        res.add(node.val);
        if(node.right != null) {
            rightBoundary(node.right);
        }
        else {
            rightBoundary(node.left);
        }
    }
    
    public void leaves(TreeNode node) {
        
        if(node.left == null && node.right == null) {
            res.add(node.val);
        }
        if(node.left != null) {
            leaves(node.left);
        }
        if(node.right != null) {
            leaves(node.right);
        }
    }
}


/*

[1,2,4,5,9,10,3]
                      1
                2              3
            4      5        6
                         9    10
                


1. Fetch the left boundary 
2. Fetch the leaves
3. Fetch the right boundary 



1,2,4



- if the node is on the left or the node is a leaf then add to res
    - if no left...go right
- if the node is on the right or the node is a left node add to res
    - if no right...go left






*/





