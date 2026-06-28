class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = grid.length;
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                mp.put(grid[i][j], mp.getOrDefault(grid[i][j], 0)+1);
            }
        }
        int repeated = -1;
        int missing = -1;

        for(int i=1; i<=n*n; i++){
            if(!mp.containsKey(i)){
                missing = i;
            }
            if(mp.getOrDefault(i, 0) > 1){
                repeated = i;
            }
        }
        return new int[] {repeated, missing};
    }
}

