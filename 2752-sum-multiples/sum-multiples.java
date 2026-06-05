class Solution {
    public int sumOfMultiples(int n) {
       if(n==0) return 0;

       if(n % 3 == 0 || n % 5 == 0 || n % 7 == 0 ){
        return n + sumOfMultiples(n-1);
       }else{
        return sumOfMultiples(n-1);
       }
    }
}