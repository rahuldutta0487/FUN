class Solution 
{
    int mod = (int)Math.pow(10,9)+7;
    public int countOfPairs(int[] nums) 
    {
        int[][] dp = new int[51][nums.length];
        for(int[] rw:dp)Arrays.fill(rw,-1);
        return (int)(khafa(nums,nums[0],0,dp)%mod);
    }
    public int khafa(int[] nums, int high, int i, int[][] dp)
    {
        if(i>=nums.length)return 1;
        if(dp[high][i]!=-1)return dp[high][i];
        int ans = 0;
        for(int j = high; j>=0; j--)
        {
            if((i!=0 && nums[i]-j<nums[i-1]-high) || nums[i]-j<0)continue;
            ans += khafa(nums,j,i+1,dp);
            ans = ans%mod;
        }
        return dp[high][i]=ans;
    }
}