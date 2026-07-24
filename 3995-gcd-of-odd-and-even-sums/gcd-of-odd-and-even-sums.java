class Solution {
    public int gcdOfOddEvenSums(int n) {
        n *=2;
        int sumOdd = 0;
        int sumEven = 0;

        while(n>0){
            if(n %2 == 0){
                sumEven += n;
            }else{
                sumOdd +=n;
            }
            n--;
        }

        return gcd(sumOdd, sumEven);
    }
    int gcd(int a, int b){
        while(b != 0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}