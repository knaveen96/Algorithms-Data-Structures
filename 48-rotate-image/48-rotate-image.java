class Solution {
    public void rotate(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        //transpose
        for(int i = 0 ; i < rows ; i++) {
            for(int j = i ; j < cols ; j++) {
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //reverse
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols/2 ; j++) {
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] = temp;
            }
        }
    }
}

/*

[1,2,3]
[4,5,6]
[7,8,9]

[7,4,1]
[8,5,2]
[9,6,3]

1 2 3
4 5 6 
7 8 9

1 4 7
2 5 8
3 6 9

00 00, 01 10, 02 20


*/