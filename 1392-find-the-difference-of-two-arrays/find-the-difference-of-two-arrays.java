class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int num : nums1){
            set1.add(num);
        }

        for(int num : nums2){
            set2.add(num);
        }
        List<Integer> list1 = new ArrayList<>(set1);
        list1.removeAll(set2);
        List<Integer> list2 = new ArrayList<>(set2);
        list2.removeAll(set1);

        return Arrays.asList(list1, list2);
    }
}