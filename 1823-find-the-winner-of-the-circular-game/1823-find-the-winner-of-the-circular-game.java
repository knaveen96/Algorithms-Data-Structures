class Solution {
    class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
    }
    
    public int findTheWinner(int n, int k) {
        
        Node left = new Node(1);
        Node root = left;
        for(int i = 2 ; i <= n ; i++) {
            Node right = new Node(i);
            right.prev = left;
            left.next = right;
            left = left.next;
        }
        left.next = root;
        root.prev = left;
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < k - 1; j++) {
                root = root.next;
            } 
            
            Node nextNode = root.next;
            root.prev.next = nextNode;
            nextNode.prev = root.prev;
            root = nextNode;
        }
        
        return root.val;
    }

}


/*
 


*/