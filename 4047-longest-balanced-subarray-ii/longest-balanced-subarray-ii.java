import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        // Compute next occurrence of each value
        Map<Integer, Integer> last = new HashMap<>();
        int[] nextPos = new int[n];
        Arrays.fill(nextPos, n);
        for (int i = n - 1; i >= 0; i--) {
            if (last.containsKey(nums[i])) {
                nextPos[i] = last.get(nums[i]);
            }
            last.put(nums[i], i);
        }

        // Build prefix "balance" array: +1 for new odd, -1 for new even
        int[] prefix = new int[n];
        Set<Integer> seen = new HashSet<>();
        int balance = 0;
        for (int i = 0; i < n; i++) {
            if (!seen.contains(nums[i])) {
                seen.add(nums[i]);
                balance += (nums[i] % 2 == 0 ? -1 : 1);
            }
            prefix[i] = balance;
        }

        SegmentTree st = new SegmentTree(prefix);
        int ans = 0;

        // Check if prefix up to some index is balanced (balance 0)
        int idx = st.findRightmostZero();
        if (idx != -1) ans = idx + 1;

        // Slide the left boundary
        for (int i = 1; i < n; i++) {
            int delta = (nums[i - 1] % 2 == 0 ? 1 : -1);
            st.update(i, nextPos[i - 1] - 1, delta);
            int r = st.findRightmostZero();
            if (r >= i) {
                ans = Math.max(ans, r - i + 1);
            }
        }

        return ans;
    }
}

// Segment tree with lazy propagation
class SegmentTree {
    int n;
    int[] mn, mx, lazy;

    SegmentTree(int[] arr) {
        n = arr.length;
        mn = new int[4 * n];
        mx = new int[4 * n];
        lazy = new int[4 * n];
        build(1, 0, n - 1, arr);
    }

    void build(int idx, int l, int r, int[] arr) {
        if (l == r) {
            mn[idx] = mx[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(idx * 2, l, mid, arr);
        build(idx * 2 + 1, mid + 1, r, arr);
        mn[idx] = Math.min(mn[idx * 2], mn[idx * 2 + 1]);
        mx[idx] = Math.max(mx[idx * 2], mx[idx * 2 + 1]);
    }

    void pushDown(int idx) {
        if (lazy[idx] != 0) {
            for (int child : new int[]{idx * 2, idx * 2 + 1}) {
                mn[child] += lazy[idx];
                mx[child] += lazy[idx];
                lazy[child] += lazy[idx];
            }
            lazy[idx] = 0;
        }
    }

    void update(int ql, int qr, int val) {
        update(1, 0, n - 1, ql, qr, val);
    }

    void update(int idx, int l, int r, int ql, int qr, int val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            mn[idx] += val;
            mx[idx] += val;
            lazy[idx] += val;
            return;
        }
        pushDown(idx);
        int mid = (l + r) / 2;
        update(idx * 2, l, mid, ql, qr, val);
        update(idx * 2 + 1, mid + 1, r, ql, qr, val);
        mn[idx] = Math.min(mn[idx * 2], mn[idx * 2 + 1]);
        mx[idx] = Math.max(mx[idx * 2], mx[idx * 2 + 1]);
    }

    // Find rightmost index where balance == 0
    int findRightmostZero() {
        return findRightmostZero(1, 0, n - 1);
    }
    int findRightmostZero(int idx, int l, int r) {
        if (mn[idx] > 0 || mx[idx] < 0) return -1;
        if (l == r) return l;
        pushDown(idx);
        int mid = (l + r) / 2;
        int rightRes = findRightmostZero(idx * 2 + 1, mid + 1, r);
        if (rightRes != -1) return rightRes;
        return findRightmostZero(idx * 2, l, mid);
    }
}
