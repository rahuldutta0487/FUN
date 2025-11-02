// class Solution {
//     public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
//         char[][] grid = new char[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 grid[i][j] = '.';
//             }
//         }
//         for (int[] guard : guards) {
//             int row = guard[0];
//             int col = guard[1];
//             grid[row][col] = 'G';
//         }
//         for (int[] wall : walls) {
//             int row = wall[0];
//             int col = wall[1];
//             grid[row][col] = 'W';
//         }
//         boolean[][] guarded = new boolean[m][n];
//         int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//         for (int[] guard : guards) {
//             int row = guard[0];
//             int col = guard[1];
//             for (int[] dir : directions) {
//                 int dr = dir[0];
//                 int dc = dir[1];
//                 int r = row + dr;
//                 int c = col + dc;
//                 while (r >= 0 && r < m && c >= 0 && c < n) {
//                     if (grid[r][c] == 'W' || grid[r][c] == 'G') {
//                         break;
//                     }
//                     guarded[r][c] = true;
//                     r += dr;
//                     c += dc;
//                 }
//             }
//         }
//         int count = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == '.' && !guarded[i][j]) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }


        int total = m * n;

        // 0 is seen
        // 1 is open
        // 2 is G or W

        for (int[] wall: walls) {
            grid[wall[0]][wall[1]] = 2;
            --total;
        }

        for (int[] guard: guards) {
            int x = guard[0];
            int y = guard[1];
            grid[x][y] = 2;
            --total;
        }

        for (int[] guard: guards) {
            int x = guard[0];
            int y = guard[1];

            // shortcut to exit early if we've seen everything. no need to check the other guards
            if (total == 0)
                return total;

            // check up
            for (int i = y-1; i >= 0; i--) {
                if (grid[x][i] == 2)
                    break;
                total -= grid[x][i];
                grid[x][i] = 0;
            }

            // check down
            for (int i = y+1; i < n; i++) {
                if (grid[x][i] == 2)
                    break;
                total -= grid[x][i];
                grid[x][i] = 0;
            }

            // check left
            for (int i = x-1; i >= 0; i--) {
                if (grid[i][y] == 2)
                    break;
                total -= grid[i][y];
                grid[i][y] = 0;
            }

            // right
            for (int i = x+1; i < m; i++) {
                if (grid[i][y] == 2)
                    break;
                total -= grid[i][y];
                grid[i][y] = 0;
            }
        }

        return total;
    }
}