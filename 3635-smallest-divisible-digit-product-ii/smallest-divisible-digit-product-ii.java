class Solution {
    // Returns minimal required digits sorted in non-decreasing order to cover factors
    private String getMinDigits(int c2, int c3, int c5, int c7) {
        StringBuilder res = new StringBuilder();
        
        // 7s and 5s are fixed
        while (c7-- > 0) res.append('7');
        while (c5-- > 0) res.append('5');
        
        // 9s from 3s
        int n9 = c3 / 2;
        c3 %= 2;

        // 8s from 2s
        int n8 = c2 / 3;
        c2 %= 3;

        // Try pairing remaining 2 and 3 into 6
        if (c3 == 1 && c2 == 1) {
            res.append('6');
            c3 = 0;
            c2 = 0;
        } else if (c3 == 1 && c2 == 2) {
            res.append('6').append('2');
            c3 = 0;
            c2 = 0;
        }

        // Remaining 3s
        if (c3 == 1) res.append('3');

        // Remaining 2s
        if (c2 == 2) res.append('4');
        else if (c2 == 1) res.append('2');

        while (n9-- > 0) res.append('9');
        while (n8-- > 0) res.append('8');

        // Sort characters in non-decreasing order
        char[] chars = res.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Factors contributed by digit d
    private int[] addFactors(char d, int c2, int c3, int c5, int c7, int delta) {
        if (d == '2') c2 += delta;
        else if (d == '3') c3 += delta;
        else if (d == '4') c2 += 2 * delta;
        else if (d == '5') c5 += delta;
        else if (d == '6') { c2 += delta; c3 += delta; }
        else if (d == '7') c7 += delta;
        else if (d == '8') c2 += 3 * delta;
        else if (d == '9') c3 += 2 * delta;
        
        return new int[]{c2, c3, c5, c7};
    }

    public String smallestNumber(String num, long t) {
        // Step 1: Factorize t
        int t2 = 0, t3 = 0, t5 = 0, t7 = 0;
        while (t % 2 == 0) { t2++; t /= 2; }
        while (t % 3 == 0) { t3++; t /= 3; }
        while (t % 5 == 0) { t5++; t /= 5; }
        while (t % 7 == 0) { t7++; t /= 7; }
        if (t > 1) return "-1"; // Prime factor > 7 cannot be formed

        int n = num.length();

        // Calculate required factors for each prefix of `num`
        int[][] req = new int[n + 1][4];
        req[0] = new int[]{t2, t3, t5, t7};
        int zeroIdx = -1;

        for (int i = 0; i < n; ++i) {
            char c = num.charAt(i);
            if (c == '0') {
                zeroIdx = i;
                break;
            }
            int[] nextReq = addFactors(c, req[i][0], req[i][1], req[i][2], req[i][3], -1);
            req[i + 1][0] = Math.max(0, nextReq[0]);
            req[i + 1][1] = Math.max(0, nextReq[1]);
            req[i + 1][2] = Math.max(0, nextReq[2]);
            req[i + 1][3] = Math.max(0, nextReq[3]);
        }

        // Check if `num` itself is valid
        if (zeroIdx == -1 && req[n][0] == 0 && req[n][1] == 0 && req[n][2] == 0 && req[n][3] == 0) {
            return num;
        }

        // Step 2: Search for longest prefix matching
        int limit = (zeroIdx == -1) ? n - 1 : zeroIdx;

        for (int i = limit; i >= 0; --i) {
            for (int d = (num.charAt(i) - '0') + 1; d <= 9; ++d) {
                int[] curr = addFactors((char)(d + '0'), req[i][0], req[i][1], req[i][2], req[i][3], -1);
                int r2 = Math.max(0, curr[0]);
                int r3 = Math.max(0, curr[1]);
                int r5 = Math.max(0, curr[2]);
                int r7 = Math.max(0, curr[3]);

                String minSuf = getMinDigits(r2, r3, r5, r7);
                int remLen = n - 1 - i;

                if (minSuf.length() <= remLen) {
                    StringBuilder res = new StringBuilder();
                    res.append(num.substring(0, i));
                    res.append(d);
                    for (int k = 0; k < remLen - minSuf.length(); k++) {
                        res.append('1');
                    }
                    res.append(minSuf);
                    return res.toString();
                }
            }
        }

        // Step 3: Minimal answer with length > n
        String minSuf = getMinDigits(t2, t3, t5, t7);
        int targetLen = Math.max(minSuf.length(), n + 1);
        StringBuilder res = new StringBuilder();
        for (int k = 0; k < targetLen - minSuf.length(); k++) {
            res.append('1');
        }
        res.append(minSuf);
        return res.toString();
    }
}