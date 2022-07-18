/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

//O(n) space
// class Solution {
//     public Node copyRandomList(Node head) {
        
//         Map<Node, Node> map = new HashMap<>();
//         Node curr = head;
        
//         while(curr != null) {
//             map.put(curr, new Node(curr.val));
//             curr = curr.next;
//         }
        
//         for(Node key : map.keySet()) {
//             Node temp = map.get(key);
//             temp.next = map.get(key.next);
//             temp.random = map.get(key.random);
//         }
        
//         return map.get(head);
//     }
// }


// O(1) space
// class Solution {
//     public Node copyRandomList(Node head) {
        
//         if(head == null) return null;
        
//         Node temp = head;
        
//         while(temp != null) {
//             temp.next = new Node(temp.val, temp.next, temp.random);
//             temp = temp.next.next;
//         }
        
//         Node new_head = head.next;
//         temp = head;
        
//         while(temp != null) {
            
//             if(temp.next.random != null) {
//                 temp.next.random = temp.next.random.next;  
//             }
//             temp = temp.next.next;
//         }
        
//         temp = head;
        
//         while(temp != null) {
//             Node copy = temp.next;
//             temp.next = copy.next;
//             if(copy.next != null) copy.next = copy.next.next;
//             temp = temp.next;
//         }
        
//         return new_head;
//     }
// }






class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return null;
        
        Node temp = head;
        
        while(temp != null) {
            temp.next = new Node(temp.val, temp.next, temp.random);
            temp = temp.next.next;
        }
        
        Node newHead = head.next;
        temp = head;
        
       while(temp != null) {
            
            if(temp.next.random != null) {
                temp.next.random = temp.next.random.next;  
            }
            temp = temp.next.next;
        }
        
        Node p = head;
        Node q = newHead;
        
        while(p != null) {
            p.next = p.next.next;
            if(q.next != null) q.next = q.next.next;
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
}


/*

 1->2->3
 h
 
 1->1->2->2->3->3
             p
                q



- random points to the same node for all new nodes.
- 


*/
















