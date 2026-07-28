class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int i=0;
        for(char ch: s.toCharArray()){
            if(set.isEmpty() || !set.contains(ch)){
                set.add(ch);
            }else{
                max = Math.max(max, set.size());

                while(s.charAt(i) != ch){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
                set.add(ch);
            }
        }
        max = Math.max(max, set.size()); 
        return max;
    }
}