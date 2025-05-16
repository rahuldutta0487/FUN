class Solution {
    long[][][] dp;
    long mod = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new long[n][m][k + 1];
        for(long[][] arr : dp){
            for(long[] ar : arr){
                Arrays.fill(ar, (long)-1);
            }
        }
        return (int)helper(grid, k, 0, 0, 0);
    }
    
    public long helper(int[][] grid, int k, int i, int j , int sum){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j][sum] != -1){
            return dp[i][j][sum];
        }
        if(i == grid.length - 1 && j == grid[0].length - 1){
            if((sum + grid[i][j]) % k == 0){
                return 1;
            }
            return 0;
        }
        
        
        return dp[i][j][sum] = (helper(grid, k, i + 1, j, (sum + grid[i][j]) % k) + helper(grid, k, i, j + 1, (sum + grid[i][j]) % k)) % mod;
        
    }
    
    
}