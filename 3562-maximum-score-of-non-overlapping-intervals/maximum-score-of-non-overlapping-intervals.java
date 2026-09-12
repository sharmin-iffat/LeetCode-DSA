import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        // arr stores: {start, end, weight, original index}
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by end time to enable binary search for non-overlapping intervals
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        // Precompute previous non-overlapping interval index for each interval
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(arr, i - 1, arr[i][0]);
        }

        // dp[i][k] stores the optimal state considering first i intervals using exactly k intervals
        State[][] dp = new State[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new int[0]);
            }
        }

        for (int i = 1; i <= n; i++) {
            int weight = arr[i - 1][2];
            int origIdx = arr[i - 1][3];
            int p = prev[i - 1] + 1; // 1-based index in DP table

            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip interval i-1
                State skip = dp[i - 1][k];

                // Option 2: Take interval i-1 (only valid if p achieved k-1 count or k=1)
                State take;
                State prevK = dp[p][k - 1];
                
                if (k == 1 || prevK.weight > 0 || prevK.indices.length == k - 1) {
                    int[] newIndices = new int[prevK.indices.length + 1];
                    System.arraycopy(prevK.indices, 0, newIndices, 0, prevK.indices.length);
                    newIndices[newIndices.length - 1] = origIdx;
                    
                    // Keep indices sorted at all times for accurate lexicographical comparison
                    Arrays.sort(newIndices);

                    take = new State(prevK.weight + weight, newIndices);
                } else {
                    take = new State(-1, new int[0]);
                }

                dp[i][k] = better(skip, take);
            }
        }

        // Find best choice across all count options k in [1..4]
        State best = new State(-1, new int[0]);
        for (int k = 1; k <= 4; k++) {
            best = better(best, dp[n][k]);
        }

        return best.indices;
    }

    private int findPrevious(int[][] arr, int right, int start) {
        int left = 0;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid][1] < start) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private State better(State a, State b) {
        if (a.weight > b.weight) return a;
        if (b.weight > a.weight) return b;
        if (a.weight < b.weight) return b;

        // On weight tie: prefer lexicographically smaller index list
        return compare(a.indices, b.indices) <= 0 ? a : b;
    }

    private int compare(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }
        return Integer.compare(a.length, b.length);
    }

    static class State {
        long weight; // Using long prevents potential integer overflow with cumulative weights
        int[] indices;

        State(long weight, int[] indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }
}