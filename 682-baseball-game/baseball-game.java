class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        int n = operations.length;

        for(int i=0; i<n; i++){
            char pres = operations[i].charAt(0);
            if(!st.isEmpty() && pres == 'C') st.pop();
            else if(!st.isEmpty() && pres == 'D'){
                int dbl = 2*st.peek();
                st.push(dbl);
            }else if(!st.isEmpty() && pres == '+'){
                int top = st.pop();
                int secTop = st.peek();
                int sum = top + secTop;
                st.push(top);
                st.push(sum);
            }else{
                st.push(Integer.parseInt(operations[i]));;
            }
        }
        int total = 0;
        for (int x : st) total += x;

        return total;
    }
}