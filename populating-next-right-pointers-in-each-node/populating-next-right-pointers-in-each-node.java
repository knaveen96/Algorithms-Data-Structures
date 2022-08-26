/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//class Solution {
    //O(N) space
//     public Node connect(Node root) {
     
//         if(root == null) return null;
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
            
//             for(int i = 0 ; i < size ; i++) {
//                 Node curr = queue.poll();
//                 if(i < size - 1) curr.next = queue.peek();
                
//                 if(curr.left != null) {
//                     queue.add(curr.left);
//                 }
//                 if(curr.right != null) {
//                     queue.add(curr.right);
//                 }
//             }
//         }
//         return root;
//     }
    
    
    
class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;
        Node leftNode = root;
        
        while(leftNode.left != null) {
            Node head = leftNode;
            
            while(head != null) {
                head.left.next = head.right;
                if(head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }
}
