class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        int sz = row*col;

        k=k%sz;

        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add(0);
            }
            ans.add(list);
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int newIdx = i*col + j +k;
                int newRow = (newIdx/col)%row;
                int newCol = newIdx % col;

                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return ans;
        
    }
}