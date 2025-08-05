class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            grid[row][col] = 'G';
        }
        for (int[] wall : walls) {
            int row = wall[0];
            int col = wall[1];
            grid[row][col] = 'W';
        }
        boolean[][] guarded = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            for (int[] dir : directions) {
                int dr = dir[0];
                int dc = dir[1];
                int r = row + dr;
                int c = col + dc;
                while (r >= 0 && r < m && c >= 0 && c < n) {
                    if (grid[r][c] == 'W' || grid[r][c] == 'G') {
                        break;
                    }
                    guarded[r][c] = true;
                    r += dr;
                    c += dc;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.' && !guarded[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}