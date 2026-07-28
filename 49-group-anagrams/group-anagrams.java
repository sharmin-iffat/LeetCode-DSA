class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            char[] arr = strs[i].toCharArray();

            Arrays.sort(arr);

            String key = new String(arr);

            if (!mp.containsKey(key)) {
                mp.put(key, new ArrayList<>());
            }

            mp.get(key).add(strs[i]);
        }
        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
        

            ans.add(entry.getValue()); 
        }
        return ans;
        
    }
}