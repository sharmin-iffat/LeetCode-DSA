class Solution {
    public int reverse(int x) {
        int ans = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while(x != 0){
            int r = x%10;
            x/=10;
            if(ans > max/10 || (ans == max/10 && r>7)){
                return 0;
            }
            if(ans < min/10 || (ans == min/10 && r<-8)){
                return 0;
            }
            ans = ans * 10 + r;
            
        }
        
        return ans;
    }
}