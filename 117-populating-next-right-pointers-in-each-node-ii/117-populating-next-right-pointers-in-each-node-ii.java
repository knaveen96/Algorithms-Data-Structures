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


//O(n) space 
// class Solution {
//     public Node connect(Node root) {
        
//         if(root == null) return null;
        
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()) {
            
//             int size = queue.size();
//             for(int i = 0 ; i < size ; i++) {
                
//                 Node curr = queue.poll();
//                 if(i < size - 1) curr.next = queue.peek();
                
//                 if(curr.left != null) queue.add(curr.left);
//                 if(curr.right != null) queue.add(curr.right);
                
//             }
//         }
        
//         return root;
//     }
// }



/*

                    1
                2       3
              4   5


*/

//O(1) space

// class Solution {
    
//     public Node connect(Node root) {
        
//         if(root == null) return null;
        
//         Node leftNode = root;
        
//         while(leftNode != null) {
            
//             Node head = leftNode;
//             Node dummy = new Node(0);
//             Node temp = dummy;
            
//             while(head != null) {
                
//                 if(head.left != null) {
//                     temp.next = head.left;
//                     temp = temp.next;
//                 }
                
//                 if(head.right != null) {
//                     temp.next = head.right;
//                     temp = temp.next;
//                 }
                    
//                 head = head.next;
//             }
            
//             leftNode = dummy.next;
//         }
        
//         return root;
        
//     }
// }





class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                Node curr = queue.poll();
                if(i < size - 1) curr.next = queue.peek();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return root;
    }
}

/*



*/




















