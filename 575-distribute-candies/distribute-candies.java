class Solution {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int type = 1;
        int i=0, j= 1;
        int n = candyType.length;
        int half = n/2;

        while(i<n && j<n){
            if(candyType[i] == candyType[j]) j++;
            else{
                i = j;

                if(type == half) return half;
                else type++;
                
            }
        }
        return type;
        
    }
}