class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<names.length; i++){
            list.add(i);
        }
        Collections.sort(list, (a, b) ->
            Integer.compare(heights[b], heights[a])
        );

        String[] ans = new String[names.length];

        for(int i=0; i<ans.length; i++){
            ans[i] = names[list.get(i)];
        }
        return ans;
        
    }
}