class Solution {
    public int maxVowels(String s, int k) {
        char[] arr =  s.toCharArray();
        int count = 0;
        int currCount = 0;
        int n = arr.length;

        int i=0, j=k;

        for(int l=0; l<k; l++){
            if(arr[l] == 'a' || arr[l] == 'e' || arr[l] == 'i' || arr[l] == 'o' || arr[l] == 'u'){
                currCount++;
            }
        }
        count = Math.max(count, currCount);

        while(j<n){
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                currCount--;
            }
            if(arr[j] == 'a' || arr[j] == 'e' || arr[j] == 'i' || arr[j] == 'o' || arr[j] == 'u'){
                currCount++;
            }
            i++;
            j++;
            count = Math.max(count, currCount);
        }
        return count;
        
    }
}