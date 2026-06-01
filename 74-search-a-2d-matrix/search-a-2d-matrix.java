class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int col = mat.length; 
        int row = mat[0].length;
        
        for(int i=0; i<col; i++){
            int j = row-1;
            while(j>=0){
                if(mat[i][j] == x) return true;
                
                else if(mat[i][j] > x) j--;
                else break;
            }
        }
        return false;
    }
}