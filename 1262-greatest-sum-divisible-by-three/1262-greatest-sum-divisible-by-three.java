class Solution {
    public int maxSumDivThree(int[] nums) {
        int m = nums.length;
        int[][] dp = new int[m + 1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i = 1; i <= m; i++){
            int current = nums[i - 1];
            if(current % 3 == 0){
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + current);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + current);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + current);
            }
            else if(current % 3 == 1){
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + current);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + current);
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + current);
            }
            else if(current % 3 == 2){
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + current);
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + current);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + current);
            }
        }
        return dp[m][0];
    }
}