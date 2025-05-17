class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return solve (q, n, 0, dp);
    }

    public long solve (int[][] q, int n, int row, long[] dp) {
        if (row >= n || row < 0) {
            return 0;
        }
        if (dp[row] != -1) {
            return dp[row];
        }
        long take = q[row][0] + solve (q, n, row + q[row][1]+1, dp);
        long not = 0 + solve (q, n, row + 1, dp);

        dp[row] = Math.max(take, not);
        return dp[row];
    }
}