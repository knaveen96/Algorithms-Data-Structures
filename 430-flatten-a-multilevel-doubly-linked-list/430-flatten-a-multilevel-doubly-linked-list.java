/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {    
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    
    public Node dfs(Node node) {
        Node pre = null;
        while(node != null) {
            pre = node;
            if(node.child != null) {
                Node tail = dfs(node.child);
                tail.next = node.next;
                if(node.next != null) node.next.prev = tail;
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
            }
            else {
                node = node.next;
            }
        }
        return pre;
    }
}

/*

Node conn = null;
- start the iteration.
- if(curr.child == null) 
    - move to the next node curr = curr.next;
- else
    - recursively call
        Node nextNode = curr.next;
        nextNode.prev = null;
        curr.next = null;
        
        curr.next = helper(curr->curr.child, );
        nextNode.prev = conn;
        
        return curr;

*/