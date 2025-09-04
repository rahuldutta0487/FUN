class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxSegment = 0;
        int[][][][][] dp = new int[3][2][4][m][n];
        for (int[][][][] four : dp) {
            for (int[][][] three : four) {
                for (int[][] two : three) {
                    for (int[] one : two) {
                        Arrays.fill(one, -1);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dir[d][0];
                        int nc = j + dir[d][1];
                        int length = 1;
                        if (isValid(nr, nc, m, n)) {
                            length += f(2, 1, d, nr, nc, grid, dp);
                        }
                        maxSegment = Math.max(maxSegment, length);
                    }
                }
            }
        }
        return maxSegment;
    }

    static int[][] dir = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

    static boolean isValid(int r, int c, int m, int n) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }

    static int f(int req, int av, int d, int r, int c, int[][] grid, int[][][][][] dp) { //give me the max length of this segment
        if (grid[r][c] != req || grid[r][c] == 1)
            return 0;

        if (dp[req][av][d][r][c] != -1)
            return dp[req][av][d][r][c];
        int furtherLength = 0;

        int maxLength = 1;
        int m = grid.length;
        int n = grid[0].length;
        int nr = r + dir[d][0];
        int nc = c + dir[d][1];
        if (isValid(nr, nc, m, n)) {
            if (req == 2) {
                furtherLength = f(0, av, d, nr, nc, grid, dp);
            } else if (req == 0) {
                furtherLength = f(2, av, d, nr, nc, grid, dp);
            }
            maxLength = 1 + furtherLength;
        }

        if (av > 0) {
            int nd = ((d + 1) % 4);
            nr = r + dir[nd][0];
            nc = c + dir[nd][1];
            if (isValid(nr, nc, m, n)) {
                if (req == 2) {
                    furtherLength = f(0, av - 1, nd, nr, nc, grid, dp);
                } else if (req == 0) {
                    furtherLength = f(2, av - 1, nd, nr, nc, grid, dp);
                }
                maxLength = Math.max(maxLength, 1 + furtherLength);
            }
        }
        return dp[req][av][d][r][c] = maxLength;
    }
}