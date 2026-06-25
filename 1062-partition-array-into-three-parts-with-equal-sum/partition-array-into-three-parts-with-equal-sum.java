class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;
        for(int i=0; i<arr.length; i++){
            totalSum += arr[i];
        }
        if(totalSum % 3 != 0) return false;
        int target = totalSum / 3;
        int sum = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum == target){
                count++;
                sum = 0;
            }
        }
        if(count >= 3) return true;
        return false;
    }
}