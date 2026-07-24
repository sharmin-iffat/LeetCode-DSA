class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;

            int reminder = columnNumber % 26;

            char ch = (char)('A' + reminder);

            ans.append(ch);

            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }
}