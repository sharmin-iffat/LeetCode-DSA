import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        List<int[]> litter = new ArrayList<>();
        int startR = 0, startC = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'L') {
                    litter.add(new int[]{i, j});
                } else if (ch == 'S') {
                    startR = i;
                    startC = j;
                }
            }
        }

        int k = litter.size();

        // No litter to clean
        if (k == 0) return 0;

        // Each state:
        // row, col, current energy, cleaned litter mask
        int totalMasks = 1 << k;

        // dist[r][c][energy][mask]
        int[][][][] dist = new int[m][n][energy + 1][totalMasks];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int e = 0; e <= energy; e++) {
                    Arrays.fill(dist[i][j][e], -1);
                }
            }
        }

        Queue<State> queue = new LinkedList<>();

        dist[startR][startC][energy][0] = 0;
        queue.offer(new State(startR, startC, energy, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            int r = cur.r;
            int c = cur.c;
            int e = cur.energy;
            int mask = cur.mask;

            int moves = dist[r][c][e][mask];

            // All litter cleaned
            if (mask == totalMasks - 1) {
                return moves;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // Outside classroom
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Wall
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                // Need energy to move
                if (e == 0) {
                    continue;
                }

                int newEnergy = e - 1;
                int newMask = mask;

                // Check if this cell contains litter
                for (int i = 0; i < k; i++) {
                    if (litter.get(i)[0] == nr &&
                        litter.get(i)[1] == nc) {

                        newMask |= (1 << i);
                        break;
                    }
                }

                // Recharge at charging cell 'R'
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                if (dist[nr][nc][newEnergy][newMask] == -1) {
                    dist[nr][nc][newEnergy][newMask] = moves + 1;

                    queue.offer(
                        new State(nr, nc, newEnergy, newMask)
                    );
                }
            }
        }

        return -1;
    }

    static class State {
        int r, c, energy, mask;

        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }
}