class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for(char ch: word.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        int ans = 0;
        int push = 1;

        ArrayList<Integer> list = new ArrayList<>(mp.values());
        int n = list.size();

        Collections.sort(list, Collections.reverseOrder());

        for(int i=0; i<n; i++){

            if(i>0 && i%8 == 0){
                push++;
            }
            ans+= list.get(i)*push;
        }

        return ans;
        
    }
}