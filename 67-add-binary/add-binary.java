class Solution {
    public String addBinary(String a, String b) {
        List<Character> list = new ArrayList<>();
        int carry =0;
        int i= a.length()-1;
        int j= b.length()-1;

        while (i >= 0 || j >= 0) {
            char cA = (i >= 0) ? a.charAt(i) : '0';
            char cB = (j >= 0) ? b.charAt(j) : '0';

            if (cA == '1' && cB == '1') {
                if (carry == 1) {
                    list.add('1');
                    carry = 1;
                } else {
                    list.add('0');
                    carry = 1;
                }
            }
            else if ((cA == '1' && cB == '0') || (cA == '0' && cB == '1')) {
                if (carry == 1) {
                    list.add('0');
                    carry = 1;
                } else {
                    list.add('1');
                    carry = 0;
                }
            }
            else { // both '0'
                if (carry == 1) {
                    list.add('1');
                    carry = 0;
                } else {
                    list.add('0');
                    carry = 0;
                }
            }

            i--;
            j--;
        }
        if(carry == 1) list.add('1');
        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for (char c : list) sb.append(c);

        return sb.toString();
        
    }
}
        