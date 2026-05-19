class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;
        int m = queries.length;
        int[] arr = new int[m];

        HashMap<Integer, Integer> map = new HashMap<>();
        int occurrence = 1;
        for(int i=0; i<n; i++){
            if(nums[i] == x){
                map.put(occurrence, i);
                occurrence++;
            }
        }
        for(int i=0; i<m; i++){
            if (map.containsKey(queries[i])) {
                arr[i] = map.get(queries[i]);
            }else{
                arr[i] = -1;
            }
        }
        return arr;
    }
}