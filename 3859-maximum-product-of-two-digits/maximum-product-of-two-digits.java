class Solution {
    public int maxProduct(int n) {
        int len = String.valueOf(n).length();
        int[] arr = new int[len+1];
        int i =0;
        while(n>0){
            int rem = n % 10;
            arr[i] = rem;
            i++;
            n /=10;
        }
        Arrays.sort(arr);

        return arr[len-1] * arr[len];
        
    }
}