class Solution {
    public void rotate(int[][] matrix) {
        int col = matrix[0].length-1;
        int row = matrix.length;

        for(int i=1; i<row; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<row; i++){
            int l = 0;
            int r =col;
            while(l<r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}