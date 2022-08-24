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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        while(!stack.isEmpty() || root != null) {
            
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            res.add(root.val);
            stack.pop();
            
            root = root.right;
        }
        return res;
    }
}


/*          
                            1
                        2       3
                    4     5    6    7
          
[4,2,5,1,6,3,7]

- left, root, right

[4,9,2]



2
1

- go as far left as possible.
    - until I hit a null insert each value onto stack.

while() 


*/