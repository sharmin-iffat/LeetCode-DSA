class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] arr = new int[n];
        arr[n-1] = 0;
        st.push(heights[n-1]);
        
        for(int i=n-2; i>=0; i--){
            int count =0;
            while(!st.isEmpty() && st.peek() <= heights[i]){
                count++;
                st.pop();
            }
            if(!st.isEmpty()) count++;
            arr[i] = count;
            st.push(heights[i]);
        }
        return arr;
    }
}