class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }
        int i;
        for(i=1; i<=100; i++){
            if(!set.contains(i*k)){
                return i*k;
            }
        }
        return i*k;
    }
}