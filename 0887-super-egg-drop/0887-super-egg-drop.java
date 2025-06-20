class Solution {
    public int superEggDrop(int k, int n) {
        int dp[][] = new int[k + 1][n + 1];
        for (int rows[] : dp) {
            Arrays.fill(rows, -1);
        }
        return eggDropHelper(k, n, dp);
    }

    private int eggDropHelper(int k, int n, int[][] dp) {
        if (n == 0 || n == 1) return n;
        if (k == 1) return n;

        if (dp[k][n] != -1) return dp[k][n];

        int min = Integer.MAX_VALUE;
        int low = 1, high = n;
        while (low <= high) {
            int mid = (low + high) / 2;

            int breakCount, noBreakCount;

            if (dp[k - 1][mid - 1] != -1) {
                breakCount = dp[k - 1][mid - 1];
            } else {
                breakCount = eggDropHelper(k - 1, mid - 1, dp);
                dp[k - 1][mid - 1] = breakCount;
            }

            if (dp[k][n - mid] != -1) {
                noBreakCount = dp[k][n - mid];
            } else {
                noBreakCount = eggDropHelper(k, n - mid, dp);
                dp[k][n - mid] = noBreakCount;
            }

            int temp = 1 + Math.max(breakCount, noBreakCount);

            if (breakCount > noBreakCount) {
                high = mid - 1;  // Move to the lower half
            } else {
                low = mid + 1;   // Move to the upper half
            }

            min = Math.min(min, temp);
        }

        return dp[k][n] = min;
    }
}