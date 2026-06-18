class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n= nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int ele : nums){
            mp.put(ele, mp.getOrDefault(ele, 0) + 1);
        }
        for(int key : mp.keySet()){
            if(mp.get(key) > n/3){
                list.add(key);
            }
        }
        return list;
    }
}