class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] one = new boolean[2048];
        boolean[] two = new boolean[2048];
        boolean[] three = new boolean[2048];

        // Possible XOR values using one element
        for (int num : nums) {
            one[num] = true;
        }

        // Possible XOR values using two elements
        for (int a = 0; a < 2048; a++) {
            if (!one[a]) continue;

            for (int b = 0; b < 2048; b++) {
                if (!one[b]) continue;

                two[a ^ b] = true;
            }
        }

        // Possible XOR values using three elements
        for (int a = 0; a < 2048; a++) {
            if (!two[a]) continue;

            for (int b = 0; b < 2048; b++) {
                if (!one[b]) continue;

                three[a ^ b] = true;
            }
        }

        // Count unique XOR values
        int answer = 0;

        for (boolean possible : three) {
            if (possible) {
                answer++;
            }
        }

        return answer;
    }
}