class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnce = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int currZeroes = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                totalOnce++;
                if(currZeroes > 0){
                    list.add(currZeroes);
                    currZeroes = 0;
                }
            }else{
                currZeroes++;
            }
        }
        if(currZeroes > 0){
            list.add(currZeroes);
        }
        if(list.size() < 2){
            return totalOnce;
        }
        int maxZeroes = 0;

        for(int i=0; i<list.size()-1; i++){
            maxZeroes = Math.max(maxZeroes, (list.get(i)+ list.get(i+1)));
        }
        
        return totalOnce + maxZeroes;
    }
}