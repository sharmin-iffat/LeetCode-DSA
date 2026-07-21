class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        List<Integer> zeroBlocks = new ArrayList<>();
        int currZeros = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                totalOnes++;
                if (currZeros > 0) {
                    zeroBlocks.add(currZeros);
                    currZeros = 0;
                }
            } else {
                currZeros++;
            }
        }
        if (currZeros > 0) {
            zeroBlocks.add(currZeros);
        }

        if (zeroBlocks.size() < 2) {
            return totalOnes;
        }

        int maxZeroGain = 0;
        for (int i = 0; i < zeroBlocks.size() - 1; i++) {
            maxZeroGain = Math.max(maxZeroGain, zeroBlocks.get(i) + zeroBlocks.get(i + 1));
        }

        return totalOnes + maxZeroGain;
    }
}