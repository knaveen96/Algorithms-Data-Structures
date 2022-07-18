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
// class Solution {
//     public ListNode swapPairs(ListNode head) {
        
//         if(head == null) return null;
//         if(head.next == null) return head;
        
//         ListNode p = head;
//         ListNode q = head;
//         ListNode temp = head;
//         ListNode new_head = p.next;
        
//         while(p != null) {
            
//             q = p.next;
//             temp = q.next;
//             q.next = p;
            
//             if(temp == null || temp.next == null) {
//                 p.next = temp;
//                 break;
//             }
 
//             p.next = temp.next;
            
//             p = temp;
//         }
        
//         return new_head;
//     }
// }




// class Solution {
//     public ListNode swapPairs(ListNode head) {
        
//         if(head == null) return null;
//         if(head.next == null) return head;
        
//         ListNode p = head;
//         ListNode q = head.next;
//         ListNode temp = q.next;
//         ListNode new_head = p.next;
        
//         while(p != null) {
            
//             q.next = p;
//             if(temp == null || temp.next == null) {
//                 p.next = temp;
//                 break;
//             }
                
//             p.next = temp.next;
            
//             p = temp;
//             q = p.next;
//             temp = q.next;
//         }
        
//         return new_head;
//     }
// }


/*

1-2-3-4-5-6-7-8

1 points to 3 and 2 points to 1
2-1-3-4-5-6-7-8

1 points to 4 and 3 points to 5
2-1-4-3-5-6-7-8



2-1-4



1-4
2-1
4-3

2-1-4-3

*/





class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode p = head;
        ListNode q = head.next;
        ListNode newHead = p.next;
        ListNode nextNode = q.next;
        
        while(p != null) {
            q.next = p;
            
            if(nextNode == null || nextNode.next == null) {
                p.next = nextNode;
                return newHead;
            }
            p.next = nextNode.next;

            q = nextNode.next;
            p = nextNode;
            nextNode = q.next;
        }
        
        return null;
    }
}




/*


 
 2->1->3
 
 1<-2  3  null
 p
    q 
       N
 
 
    1<-2  3->4
          p  
             q
          n
 

q.next = p;
p.next = nextNode.next;

q = nextNode.next;
p = nextNode;
nextNode = q.next;


*/



















