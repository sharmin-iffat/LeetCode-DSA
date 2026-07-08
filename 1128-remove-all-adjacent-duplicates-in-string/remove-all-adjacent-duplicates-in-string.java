class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i<s.length()){
            char curr = s.charAt(i);

            if(st.isEmpty() || curr != st.peek()){
                st.push(curr);
            }else{
                st.pop();
            }
            i++;
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();;
        return ans.toString();

    }
}