/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
//         buildMap(root);
//         Queue<TreeNode> queue = new LinkedList<>();
//         List<Integer> resList = new ArrayList<>();
//         Set<TreeNode> seen = new HashSet<>();
        
//         queue.add(target);
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
//             if(k == 0) {
//                 break;
//             }
            
//             for(int i = 0 ; i < size ; i++) {
//                 TreeNode curr = queue.poll();
//                 seen.add(curr);
   
//                 if(curr.left != null && !seen.contains(curr.left)) {
//                     queue.add(curr.left);
//                 }
//                 if(curr.right != null && !seen.contains(curr.right)) {
//                     queue.add(curr.right);
//                 }
//                 if(childParentMap.containsKey(curr) && !seen.contains(childParentMap.get(curr)) && childParentMap.get(curr) != null) {
//                     queue.add(childParentMap.get(curr));
//                 }
//             }
//             k--;
//         }
        
//         for(TreeNode node : queue)    
//             resList.add(node.val);
//         return resList;
//     }
    
//     private void buildMap(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
//             for(int i = 0 ; i < size ; i++) {
                
//                 TreeNode curr = queue.poll();
                
//                 if(!childParentMap.containsKey(curr)) {
//                     childParentMap.put(curr, null);
//                 }
                
//                 if(curr.left != null) {
//                     queue.add(curr.left);
//                     childParentMap.put(curr.left, curr);
//                 }
                
//                 if(curr.right != null) {
//                     queue.add(curr.right);
//                     childParentMap.put(curr.right, curr);
//                 }
//             }
//         }
//     }
// }






/*
Turn it to an undirectional graph using a hashmap
We need to turn it beacause we also need the access to the parent node
*/





//dfs approach
class Solution {
    
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        findNodeDistanceFromTarget(root, target, k);
        return res;
    }
    
    public int findNodeDistanceFromTarget(TreeNode node, TreeNode target, int k) {
        
        if(node == null) return -1;
        
        if(node.val == target.val) {
            addAllNodes(node, target, k, 0);
            return 1;
        }
        
        int leftCount = findNodeDistanceFromTarget(node.left, target, k);
        int rightCount = findNodeDistanceFromTarget(node.right, target, k);
        
        if(leftCount == k || rightCount == k) {
            res.add(node.val);
        }
        
        if(leftCount != -1) {
            addAllNodes(node.right, target, k - leftCount - 1, 0);
            return leftCount + 1;
        }
        
        if(rightCount != -1) {
            addAllNodes(node.left, target, k - rightCount - 1, 0);
            return rightCount + 1;
        }
        
        return -1;
    }
    
    public void addAllNodes(TreeNode node, TreeNode target, int k, int distance) {
        
        if(node == null) return;
        
        if(distance == k) {
            res.add(node.val);
            return;
        }
        
        addAllNodes(node.left, target, k, distance + 1);
        addAllNodes(node.right, target, k, distance + 1);
    }
    
    
}




/*

                  1
              /        \
            2           3
        /      \      /     \
      4        5     6       7 
    /  \      / \    / \    /  \
   8    9   10  11  12  13  14  15
                            /    \
                           20     16

target = 7
k = 2

res = [16, 20, 6, 1]






*/














