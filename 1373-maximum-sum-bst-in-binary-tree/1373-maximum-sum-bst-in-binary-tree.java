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
    
    class NodeWrapper {
        int min;
        int max;
        int sum;
        public NodeWrapper(int min, int max, int sum) {
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return maxSum;
    }
    
    //post order traversal
    public NodeWrapper maxSumBSTHelper(TreeNode node) {
        //base?
        if(node == null) {
            return new NodeWrapper(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeWrapper left = maxSumBSTHelper(node.left);
        NodeWrapper right = maxSumBSTHelper(node.right);
        
        if(left != null && right != null) {
            if(left.max < node.val && node.val < right.min) {
                int sum = node.val + left.sum + right.sum;
                maxSum = Math.max(sum, maxSum);
                return new NodeWrapper(Math.min(node.val, left.min),
                                       Math.max(node.val, right.max), sum);
            }
        }
        return null;
    }
}


/*
- cannot do inorder and cal the max at the go
- do a pre order to check if the tree formed at the root is a BST.
- if yes then;
    - calculate the sum 
    - update max

5:      {min, max, sum}
left =  {4, 4, 4}
right = {6, 6, 6}

if(left min < 5 < right min)
    return new int[]{4, 6, 15}
3:   
left =  {2, 2, 2}
right = {4, 6, 15}

1:



*/