class Solution {
    final int mod = (int)1e9+7;
    final long[][] dp = new long[1001][1001];
    
    public int rearrangeSticks(int n, int k) {
        
        return (int)helper(n, k);
    }
    
    private long helper(int n, int k)
    {
        if(n == k) return 1;
        if(k == 0) return 0;
        
        if(dp[n][k] != 0) return dp[n][k];
        long ans = 0;
        ans = (ans + helper(n-1, k-1)) % mod;  // case where we dont pick the current Nth Stick
        ans = (ans + (n-1)*helper(n-1, k)) % mod; // case where we pick the Current Stick so we will be left with (n-1) possibilities
        
        dp[n][k] = ans;
        
        return dp[n][k];
    }
}