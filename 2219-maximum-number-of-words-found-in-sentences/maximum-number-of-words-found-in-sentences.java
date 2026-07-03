class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWord = 0;
        int n = sentences.length;
        
        for(int i=0; i<n; i++){
            int currMaxWord = 1;
            for(int j=0; j<sentences[i].length(); j++){
                char ch = sentences[i].charAt(j);
                if(ch == ' '){
                    currMaxWord++;
                }
                
            }
            maxWord = Math.max(currMaxWord, maxWord);
        }
        return maxWord;
    }
}