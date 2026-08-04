class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;

        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        double avg = sum/k;

        if(avg >= threshold) count++;

        int i=0, j=k;

        while(j<arr.length){
            sum -= arr[i++];
            sum += arr[j++];

            avg = sum /k;
            if(avg >= threshold) count++;
        }
        return count;
        
    }
}