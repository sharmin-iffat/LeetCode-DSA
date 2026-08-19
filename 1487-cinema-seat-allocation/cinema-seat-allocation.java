import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> rows = new HashMap<>();

        // Store reserved seats using bitmask
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            rows.put(row, rows.getOrDefault(row, 0) | (1 << (col - 1)));
        }

        // Rows without any reserved seats can fit 2 families
        int ans = (n - rows.size()) * 2;

        
        int leftMask = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4);
        int middleMask = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6);
        int rightMask = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8);

        for (int mask : rows.values()) {

            boolean left = (mask & leftMask) == 0;
            boolean middle = (mask & middleMask) == 0;
            boolean right = (mask & rightMask) == 0;

            if (left && right) {
                ans += 2;
            } 
            else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}