/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = head.next;
        
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            if(nextNode != null)nextNode = nextNode.next;
        }
        return prev;
    }
}

/*

[1,2,3,4,5]

[5,4,3,2,1]


  1  2->3->4->5 
p 
  c  
     n


*/