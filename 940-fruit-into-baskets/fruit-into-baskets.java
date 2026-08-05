class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = fruits.length;
        int l=0;
        int max = 0;

        for(int r=0; r<n; r++){
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0)+1);

            while(mp.size() > 2){
                mp.put(fruits[l], mp.get(fruits[l]) - 1);

                if(mp.get(fruits[l]) == 0){
                    mp.remove(fruits[l]);
                }
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}