class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        int i = nums[0];
        int n = nums.length;
        int idx = 0;

        while(i< nums[n-1]){
            if(nums[idx] != i){
                list.add(i);
                
            }else{
                idx++;
            }
            i++;
        }

        return list;
    }
}