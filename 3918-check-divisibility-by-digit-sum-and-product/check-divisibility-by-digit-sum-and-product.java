class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int a =0;
        int b = 1;

        while(num>0){
            int rem = num%10;
            a += rem;
            b *=rem;
            
            num/=10;
        }
        int sum = a+b;

        return n%sum == 0 ? true : false;
    }
}