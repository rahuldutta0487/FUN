public class Solution {
    private static final int FILLED = 1;

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        // fill empty space with negative number, which indicates consecutive number of rows that have been empty
        int height = grid.length, width = grid[0].length;
        int[] pre = new int[width];
        Arrays.fill(pre, 1);
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (grid[r][c] != FILLED) {
                    grid[r][c] = pre[c] == 1 ? -1: Math.max(pre[c] - 1, -stampHeight);
                }
            }
            pre = grid[r];
        }

        // scan each height, and once we find consecutive `grid` of `-stampHeight` of length `stampWidth` or longer,
        // replace the `grid` value with `FILLED`
        for (int r = stampHeight - 1; r < height; r++) {
            int cnt = 0;
            for (int c = 0; c < width; c++) {
                if (grid[r][c] == -stampHeight) cnt++;
                else cnt = 0;
                if (cnt == stampWidth) fill(grid, r, c, stampHeight, stampWidth);
                if (cnt > stampWidth) fill(grid, r, c, stampHeight, 1);
                // width set to 1 for performance; the previous width 0 - cnt would have been already filled
            }
        }

        // check if there is remaining cell of value that is not `FILLED`
        for (int[] ints : grid) {
            for (int v: ints) {
                if (v != FILLED) return false;
            }
        }
        return true;
    }

    private void fill(int[][] grid, int r, int c, int height, int width) {
        for (int i = c - width + 1; i <= c; i++) {
            int j = r;
            while (j >= r - height + 1 && grid[j][i] != FILLED)
                grid[j--][i] = FILLED;
        }
    }
}