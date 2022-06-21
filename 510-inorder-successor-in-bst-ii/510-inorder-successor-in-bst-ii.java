/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        
        Node res = null;
        
        if(node.right != null) {
            node = node.right;
            
            while(node != null) {
                res = node;
                node = node.left;
            }
        }
        else {
            while(node.parent != null) {
                if(node.val < node.parent.val) {
                    res = node.parent;
                    break;
                }
                node = node.parent;
            }
        }
        
        return res;
    }
}

/*


*/