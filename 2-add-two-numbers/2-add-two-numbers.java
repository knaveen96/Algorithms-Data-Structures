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
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
//         ListNode sum = new ListNode(-1);
//         ListNode head = sum;
//         int carry = 0;
        
//         while(l1 != null && l2 != null){
            
//             int add = l1.val + l2.val + carry;
//             sum.next = new ListNode(add>=10? add %10: add);
//             carry = add/10;
            
//             sum = sum.next;
//             l1 = l1.next;
//             l2 = l2.next;
//         }
        
//         while(l1 != null){
//             int add = l1.val + carry;
//             sum.next = new ListNode(add>=10? add %10: add);
//             carry = add/10;
//             sum = sum.next;
//             l1 = l1.next;
//         }
        
//         while(l2 != null){
//             int add = l2.val + carry;
//             sum.next = new ListNode(add>=10? add %10: add);
//             carry = add/10;
//             sum = sum.next;
//             l2 = l2.next;
//         }
        
//         if(carry != 0)
//             sum.next = new ListNode(carry);
        
//         return head.next;
//     }
// }

// l1 = [2,4,3], l2 = [5,6,4]

// add(18 %10) = 8

// 18/10







class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode sum = new ListNode(-1);
        ListNode res = sum;
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            int val = val1 + val2 + carry;
            sum.next = new ListNode(val >= 10 ? val % 10 : val);
            carry = val/10;
            
            sum = sum.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        
        if(carry != 0)
            sum.next = new ListNode(carry);
        
        return res.next;
    }
}




/*
 l1 = [2,4,3]
 l2 = [5,6,4]
 
 

[9,9,9,9,9,9,9]
 ^
[9,9,9,9]
 ^

[8,9,9,9,0,0,0,1]



*/
















