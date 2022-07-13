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
//     public List<List<Integer>> verticalOrder(TreeNode root) {
     
//         List<List<Integer>> res = new ArrayList<>();
//         if(root == null) return res;
        
//         Map<Integer, List> map = new HashMap<>();
//         Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//         queue.add(new Pair<>(root, 0));
//         int minVal = 0;
//         int maxVal = 0;
        
//         while(!queue.isEmpty()) {
            
//             int size = queue.size();
            
//             for(int i = 0 ; i < size ; i++) {
//                 Pair<TreeNode, Integer> pair = queue.poll();
//                 TreeNode curr = pair.getKey();
//                 int col = pair.getValue();
                
//                 if(!map.containsKey(col)) {
//                     map.put(col, new ArrayList<Integer>());
//                 }
//                 map.get(col).add(curr.val);
                
//                 if(curr.left != null) {
//                     queue.add(new Pair<>(curr.left, col - 1));
//                     minVal = Math.min(minVal, col - 1);
//                 }
                    
//                 if(curr.right != null) {
//                     queue.add(new Pair<>(curr.right, col + 1));
//                     maxVal = Math.max(maxVal, col + 1);
//                 }
//             }
//         }
//         for(int i = minVal ; i <= maxVal ; i++) res.add(map.get(i));
//         return res;
//     }
// }

/*

sorting

0,{3,0,1}
-1,{9}
1,{8}
-2,{4}
2,{7}

queue ->   


*/


class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer, List> map = new HashMap<>();
        int minVal = 0;
        int maxVal = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode currNode = curr.getKey();
            int order = curr.getValue();
            
            if(map.containsKey(order)) {
                map.get(order).add(currNode.val);
            } else {
                map.put(order, new ArrayList<>());
                map.get(order).add(currNode.val);
            }
            
            if(currNode.left != null) {
                queue.add(new Pair(currNode.left, order - 1));
                minVal = Math.min(minVal, order - 1);
            }
            
            if(currNode.right != null) {
                queue.add(new Pair(currNode.right, order + 1));
                maxVal = Math.max(maxVal, order + 1);
            }
        }
        
        for(int i = minVal ; i <= maxVal ; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}











