class Solution {
    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int val : nums){
            mp.put(val, mp.getOrDefault(val, 0) +1);
        }

        for(int key : mp.keySet()){
            int a = key - 1;
            int b = key + 1;
            if(mp.get(key) == 1 && !mp.containsKey(a) && !mp.containsKey(b)){
                list.add(key);;
            }
            
        }
        return list;
    }
}