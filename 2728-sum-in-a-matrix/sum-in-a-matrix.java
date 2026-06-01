class Solution {
    public int matrixSum(int[][] nums) {
        int col = nums.length;
        int row = nums[0].length;
        int score =0;

        for (int[] rows : nums) {
            Arrays.sort(rows);
        }
        
        for(int i=0; i<row; i++){
            int curr = Integer.MIN_VALUE;
            for(int j=0; j<col; j++){
                curr = Math.max(curr, nums[j][i]);
            }
            score +=curr;
        }
        return score;
    }
}