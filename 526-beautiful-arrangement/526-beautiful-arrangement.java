// class Solution {
//     public int countArrangement(int n) {
    
//         boolean[] visited = new boolean[n+1];

//         return backtrack(n, 1, visited);
//     }
    
//     private int backtrack(int n, int position, boolean[] visited) {
        
//         if(position > n) return 1;

//         int count = 0;
//         for(int i = 1 ; i <= n ; i++) {
            
//             if(!visited[i] && (position%i == 0 || i%position == 0)) {
//                 visited[i] = true;
//                 count += backtrack(n, position + 1, visited);
//                 visited[i] = false;
//             }
//         }
        
//         return count;
//     }
// }



/*
1 2 3 4
                1 2 3 4
            1     2
        12   13
     123 124
   1234

*/




class Solution {
    public int countArrangement(int n) {
        
        boolean[] visited = new boolean[n + 1];
        return backtrack(n, visited, 0, 1);
    }
    
    public int backtrack(int n, boolean[] visited, int size, int pos) {
        
        if(size == n) return 1; 
            
        int count = 0;
        for(int i = 1 ; i <= n ; i++) {
            if(!visited[i] && (pos%i == 0 || i%pos == 0)) {
                visited[i] = true;
                count += backtrack(n, visited, size + 1, pos + 1);
                visited[i] = false;
            }
        }
        return count;
    }
}


/*
1 to n integers
 
 - perm[i]/i
 - i/perm[i]
 
 1 2 3
 
  1 2 3
 [1 2 3]

  1 2 3
 [2 1 3]
 
  1 2 3
 [3 2 1]
 
                     n=3
                    1,2,3
            [1]       [2]       [3]
       [1 3 2]     
                    

*/










        
        
        
        
        
        
        
        
        
        
        
        



