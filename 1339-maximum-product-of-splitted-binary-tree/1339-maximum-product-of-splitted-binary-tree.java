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
    List<Integer> list = new ArrayList<>();
    public int maxProduct(TreeNode root) {
        long totalSum = maxProductHelper(root);
        long res = 0;
        for(int sum : list) {
            res = Math.max(res, sum*(totalSum - sum));
        }
        return (int) (res%1000000007);
    }
    
    public int maxProductHelper(TreeNode root) {
        
        if(root == null) return 0;
        
        int leftSum = maxProductHelper(root.left);
        int rightSum = maxProductHelper(root.right);
        int totalBrachSum = leftSum + rightSum + root.val;
        list.add(totalBrachSum);
        return totalBrachSum;
    }
}

/*

- post order traversal
- then i have all the sums.
- 

[4,5,11,6,9,21]

last val in the array is the total sum.

4*(21-4)
5*(21-5)
11*(21-11)


*/