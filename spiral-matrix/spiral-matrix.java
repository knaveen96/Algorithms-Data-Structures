class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = cols - 1;
        int up = 0; 
        int down = rows - 1;
        List<Integer> res = new ArrayList<>();
        
        while(res.size() < rows*cols) {
            for(int i = left ; i <= right ; i++) {
                res.add(matrix[up][i]);   
            }
            
            for(int i = up + 1 ; i <= down ; i++) {
                res.add(matrix[i][right]);   
            }
            
            if(up != down) {
                for(int i = right - 1 ; i >= left ; i--) {
                    res.add(matrix[down][i]);   
                }
            }
            
            if(right != left) {
                for(int i = down - 1 ; i > up ; i--) {
                    res.add(matrix[i][left]);   
                }
            }
            
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}


/*
   0  1  2  3
0 [1, 2, 3, 4]
1 [5, 6, 7, 8]
2 [9,10,11,12]



[1,2,3,4,8,12,11,10,9,5,6,7,6]
[1,2,3,4,8,12,11,10,9,5,6,7]




   0 1 2 
0 [1,2,3]
1 [4,5,6]
2 [7,8,9]

[1,2,3,6,9,8,7,4,5]


while()
    left -> right
    up -> down
    right -> left
    down -> up



*/