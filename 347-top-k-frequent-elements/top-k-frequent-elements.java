class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[nums.length];

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int idx = 0;
        while(k != 0){
            int key = mp.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

            mp.remove(key);
            ans[idx++] = key;
            k--;
        }
        return Arrays.copyOf(ans, idx);
    }
}