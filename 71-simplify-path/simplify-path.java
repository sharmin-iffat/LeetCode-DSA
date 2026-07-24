class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");

        Stack<String> st = new Stack<>();

        for(String part:parts){
            if(part.equals("") || part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else{
                st.push(part);
            }
        }
        StringBuilder ans = new StringBuilder();

        for(String dir: st){
            ans.append("/");
            ans.append(dir);
        }
        if(ans.length() == 0){
            return "/";
        }
        return ans.toString();
        
    }
}