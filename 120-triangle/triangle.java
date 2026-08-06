class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();

        for(int i=0; i<triangle.size(); i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0; j< triangle.get(i).size(); j++){
                if(i == 0) list.add(triangle.get(i).get(j));
                else if(j==0){
                    list.add(triangle.get(i).get(j) + dp.get(i-1).get(j));
                }else if(j == triangle.get(i).size()-1){
                    list.add(triangle.get(i).get(j) + dp.get(i-1).get(j-1));
                }
                else{
                    list.add(triangle.get(i).get(j) + (Math.min(dp.get(i-1).get(j-1), dp.get(i-1).get(j))));
                }
            }
            dp.add(list);
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0; j< dp.get(dp.size() -1).size(); j++){
            ans = Math.min(ans, dp.get(dp.size() -1).get(j));
        }
        return ans;
    }
}