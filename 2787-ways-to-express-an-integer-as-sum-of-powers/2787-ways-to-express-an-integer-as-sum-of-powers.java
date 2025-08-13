class Solution {
    public int numberOfWays(int n, int x) {
        int[] dp=new int[n+1];
        int m=1000000007;
        dp[0]=1;
        for(int i=1;i<=n;i++)
        {
            int k=(int)Math.pow(i,x);
            for(int j=n;j>=k;j--)
            {
                dp[j]=(dp[j]+dp[j-k])%m;
            }
        }
        return dp[n];
    }
}