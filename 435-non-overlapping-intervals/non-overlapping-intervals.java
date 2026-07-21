class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int row = intervals.length;
        int col = intervals[0].length;
        if (row == 0) {
            return 0;
        }
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<row; i++){
            int[] arr =new int[col];
            for(int j=0; j<col; j++){
                arr[j] = intervals[i][j];
            }
            list.add(arr);
        }
        Collections.sort(list, (a,b) -> Integer.compare(a[1], b[1]));
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        int ans = 0;

        for(int i=1; i<row; i++){
            int currStart = list.get(i)[0];
            int currEnd = list.get(i)[1];

            if(currStart < end) ans++;
            else end = currEnd;
        }
        return ans;
        
    }
}