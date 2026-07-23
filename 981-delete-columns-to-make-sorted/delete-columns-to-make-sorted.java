class Solution {
    public int minDeletionSize(String[] strs) {

        int count = 0;

        // Iterate through each column
        for (int j = 0; j < strs[0].length(); j++) {

            // Compare adjacent rows
            for (int i = 0; i < strs.length - 1; i++) {

                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}