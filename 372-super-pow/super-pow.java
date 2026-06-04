class Solution {
    int pow(int a, int b){
        if(b==0) return 1;
        int mod = 1337;
        
        int call = pow(a, b/2);

        if(b%2 == 0) return (int)((1L * call * call) % mod);
        else return (int)((1L * a * call * call) % mod);

    }
     public int superPow(int a, int[] b) {
        int mod = 1337;
        int ans = 1;

        for(int digit : b){
            ans = (pow(ans, 10) * pow(a, digit)) % mod;
        }

        return ans;
    }
}