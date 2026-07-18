class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n= nums.length;
        if(n == 0) return 0;

        int maxCount =1;

        for(int num:nums) set.add(num);

        
        for (int num : set){
            if(!set.contains(num-1)){
                
                int count = 1;
                int curr = num;

                while(set.contains(curr +1)){
                    curr++;
                    count++;
                }

                maxCount = Math.max(count, maxCount);

            }
        }
        return maxCount;
    }
}
