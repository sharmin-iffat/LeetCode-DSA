class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        long[] prefix = new long[n+1];

        //if(n==1) return s;

        for(int i=1; i<=n; i++){
            prefix[i] = shifts[i-1] + prefix[i-1];
        }
        
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            long noOfShifts = (prefix[n] - prefix[i])%26;
            
            ans.append((char)(ch + noOfShifts));

            if(ans.charAt(i) > 'z'){
                ans.setCharAt(i, (char) (ans.charAt(i) - 26));
            }
            
        }
        return ans.toString();
    }
}