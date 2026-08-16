class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        // Count stones based on remainder
        for (int stone : stones) {
            count[stone % 3]++;
        }

        // Number of remainder-0 stones is even
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        // Number of remainder-0 stones is odd
        return Math.abs(count[1] - count[2]) > 2;
    }
}