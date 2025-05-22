class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
         int n = nums.length;
    double[] prefixSum = new double[n + 1];
    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    double[][] dp = new double[n][k + 1];
    for (int i = 0; i < n; i++) {
        dp[i][1] = (prefixSum[n] - prefixSum[i]) / (n - i);
    }
    for (int group = 2; group <= k; group++) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][group] = Math.max(dp[i][group], dp[j][group - 1] + (prefixSum[j] - prefixSum[i]) / (j - i));
            }
        }
    }

    return dp[0][k];
    }
}