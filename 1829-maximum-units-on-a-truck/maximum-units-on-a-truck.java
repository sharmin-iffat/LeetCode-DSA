class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int ans =0;
        int target = 0;
        int i = 0;

        while(i< boxTypes.length){
            if(target == truckSize) return ans;

            if(target < truckSize){
                int spc = truckSize - target;
                if(boxTypes[i][0] < spc){
                    target += boxTypes[i][0];
                    ans += (boxTypes[i][0] * boxTypes[i][1]);
                }else{
                    target += spc;
                    ans += (spc * boxTypes[i][1]);
                }
                i++;
            }
        }
        return ans;
    }
}