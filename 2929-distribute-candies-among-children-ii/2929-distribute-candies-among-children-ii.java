class Solution {
    public long distributeCandies(int n, int limit) {
    long[] dp = new long[n + 1];
    dp[0] = 1;
    for (int p = 0; p < 3; ++p) {
        long[] newDp = new long[n + 1];
        long[] prefix = new long[n + 2];
        for (int i = 0; i <= n; ++i)
            prefix[i + 1] = prefix[i] + dp[i];
        for (int i = 0; i <= n; ++i) {
            int l = Math.max(0, i - limit), r = i;
            newDp[i] = prefix[r + 1] - prefix[l];
        }
        dp = newDp;
    }
    return dp[n];
}
}