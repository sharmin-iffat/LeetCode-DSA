class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(0);
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                ans[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}