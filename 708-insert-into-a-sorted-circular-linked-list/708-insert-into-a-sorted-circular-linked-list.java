/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        
        Node newNode = new Node(insertVal);
        if(head == null) {
            newNode.next = newNode;
            return newNode;
        }
        
        Node curr = head;
        
        while(curr.next != head) {
            int currVal = curr.val;
            int nextVal = curr.next.val;
            
            if(currVal <= insertVal && insertVal <= nextVal) {
                break;
            }
            else if(currVal > nextVal) {
                if(currVal >= insertVal && nextVal >= insertVal) {
                    break;
                }
                if(currVal <= insertVal && nextVal <= insertVal) {
                    break;
                }
            }
            curr = curr.next;
        }
        
        Node nextNode = curr.next;
        curr.next = newNode;
        newNode.next = nextNode;
        
        return head;
        
    }
}


/*

currVal <= insertVal <= nextVal -> insert
currVal > nextVal && (currVal >= insertVal && nextVal >= insertVal) -> insert
currVal > nextVal && (currVal <= insertVal && nextVal <= insertVal) -> insert






*/









