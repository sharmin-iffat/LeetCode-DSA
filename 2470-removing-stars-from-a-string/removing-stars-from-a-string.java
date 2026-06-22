class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != '*'){
                st.push(ch);
            }else{
                st.pop();
            }
        }
        while(st.size() != 0){
            str.append(st.pop());
        }
        String ans = new StringBuilder(str).reverse().toString();

        return ans;

    }
}