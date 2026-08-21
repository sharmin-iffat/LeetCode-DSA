

class Solution {
    // Record to store subset details: LCM value and Inclusion-Exclusion sign (+1 or -1)
    private record Subset(long lcm, int sign) {}

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        List<Subset> subsets = new ArrayList<>();

        // Generate all 2^n - 1 non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcmVal = 1;
            int bitCount = 0;

            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    bitCount++;
                    lcmVal = lcm(lcmVal, coins[i]);
                }
            }

            int sign = (bitCount % 2 == 1) ? 1 : -1;
            subsets.add(new Subset(lcmVal, sign));
        }

        // Binary Search Range Setup
        long minCoin = coins[0];
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long low = minCoin;
        long high = minCoin * (long) k;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (countMultiples(mid, subsets) >= k) {
                ans = mid;
                high = mid - 1; // Try finding a smaller valid amount
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Counts unique numbers <= val divisible by at least one coin using IEP
    private long countMultiples(long val, List<Subset> subsets) {
        long count = 0;
        for (Subset subset : subsets) {
            count += subset.sign * (val / subset.lcm);
        }
        return count;
    }

    // Greatest Common Divisor
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Least Common Multiple
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}