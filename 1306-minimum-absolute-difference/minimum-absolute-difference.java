class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(arr);
        int i =0;
        int j = i+1;
        int min = Integer.MAX_VALUE;
        while(i<j && j<arr.length){
            int diff = Math.abs(arr[i] - arr[j]);

            if(min > diff){
                min = diff;
                list.clear(); 
                list.add(Arrays.asList(arr[i], arr[j]));
            } else if(min == diff){
                list.add(Arrays.asList(arr[i], arr[j]));
            }
            i++;
            j++;

        }
        return list;
    }
}