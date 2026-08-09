class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        helper(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    public void helper(int[] nums, int i, ArrayList<Integer> list, List<List<Integer>> ans) {
        if(i == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        helper(nums, i + 1, list, ans);
        list.remove(list.size()-1);
        helper(nums, i+1, list, ans);

    }
}