class Solution {
    public int findMinArrowShots(int[][] points) {
        int row = points.length;
        if(row == 0) return 0;
        int col = points[0].length;

        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<row; i++){
            int[] arr = new int[col];
            for(int j=0; j<col; j++){
                arr[j] = points[i][j];
            }
            list.add(arr);
        }
        Collections.sort(list, (a,b) -> Integer.compare(a[1], b[1]));

        int arrowPosition = list.get(0)[1];
        int arrows = 1;

        for(int i=1; i<row; i++){
            int currStart = list.get(i)[0];

            if(currStart > arrowPosition){
                arrows++;

                arrowPosition = list.get(i)[1];
            } 
        }
        return arrows;
        
    }
}