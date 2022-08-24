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
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i < inorder.length ; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(preorder, 0, inorder.length - 1);
        
    }
    
    public TreeNode constructTree(int[] preorder, int left, int right) {
        
        if(left > right) return null;
        
        TreeNode node = new TreeNode(preorder[index]);
        int mid = map.get(preorder[index++]);
        
        node.left = constructTree(preorder, left, mid - 1);
        node.right = constructTree(preorder, mid + 1, right);
        
        return node;
    }
}


/*

            0 1  2  3 4
preorder = [3,9,20,15,7] -> node, left, right

           0 1  2  3 4
inorder = [9,3,15,20,7] -> left, node, right

                                    3
                               9          20
                                       15    7
                                       
                        
- pre order will give me the curr root val.
- check for 3's index in the inorder
    - 3's index is 1
    - recursion:
        - (0, 0) (2, 4)
- for(0,0)
    - root is 0
- for(2,4)
    - root is 2
        - recursion: (2,2) (4,4)


                                    3
                                    
                                        


*/