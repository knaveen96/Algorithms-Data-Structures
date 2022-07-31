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
    List<List<Integer>> res;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);

        for(int key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public int dfs(TreeNode root) { //4
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left); //0
        int right = dfs(root.right); //0
        int val = Math.max(left, right);//0
        
        if(!map.containsKey(val)) {
            map.put(val, new ArrayList<>());
        }
        map.get(val).add(root.val);

        return 1 + val;
    }
}