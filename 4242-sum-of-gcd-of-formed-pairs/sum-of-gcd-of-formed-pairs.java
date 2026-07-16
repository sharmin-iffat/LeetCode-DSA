class Solution {
    public long gcdSum(int[] nums) {
        int n= nums.length;

        int[] prefixGcd = new int[n];
        int max = 0;

        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(max, nums[i]);
            
        }
        Arrays.sort(prefixGcd);
        int i=0, j=prefixGcd.length-1;
        long sum = 0;
        while(i<j){
            sum += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}