class Solution {
    int dp[][];

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        // Step 1: Calculate total sum
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // Step 2: If total sum is odd, we can't split it into two equal subsets
        if(sum % 2 != 0) return false;

        int target = sum / 2;

        // Step 3: Initialize DP array (memoization table)
        dp = new int[n][target + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1); // -1 means unvisited
        }

        // Step 4: Bottom-Up DP Approach
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= target; j++) {

                // Base case: 0 sum is always possible (take nothing)
                if(j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                // If only first element, check if it matches required sum
                if(i == 0) {
                    dp[i][j] = (j == nums[i]) ? 1 : 0;
                    continue;
                }

                int take = 0;
                // Take current element if it does not exceed target
                if(j >= nums[i]) {
                    take = dp[i - 1][j - nums[i]];
                }

                // Or don't take current element
                int notTake = dp[i - 1][j];

                // If any of the choices work, mark this state as true (1)
                dp[i][j] = (take > 0 || notTake > 0) ? 1 : 0;
            }
        }

        // Final answer is whether we can form 'target' using all elements
        return dp[n - 1][target] > 0;

        // Optional: You can also use the top-down recursive function below:
        // return checkFor(n - 1, target, nums) > 0;
    }

    // Top-down recursive DP (optional)
    int checkFor(int i, int t, int[] nums) {
        if(t == 0) return dp[i][t] = 1;

        if(i == 0) return dp[i][t] = (t == nums[i]) ? 1 : 0;

        if(dp[i][t] != -1) return dp[i][t];

        int take = 0;
        if(t >= nums[i]) {
            take = checkFor(i - 1, t - nums[i], nums);
        }

        int notTake = checkFor(i - 1, t, nums);

        return dp[i][t] = (take > 0 || notTake > 0) ? 1 : 0;
    }
}