class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Prefix sum logic remains the same
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0) grid[i][j] += grid[i-1][j];
                if (j > 0) grid[i][j] += grid[i][j-1];
                if (i > 0 && j > 0) grid[i][j] -= grid[i-1][j-1];
            }
        }

        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] <= k) {
                    ans++;
                } else {
                    // Fail logic: Breaks the inner loop early
                    // This will fail cases where grid[i][j] > k but grid[i+1][j] could still be relevant
                    break; 
                }
            }
        }
        return ans;
    }
}