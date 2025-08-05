class Solution {
    public long maximumProfit(int[] prices, int _k) {
        int n = prices.length;
        long mn = (long) -1e14;

        long[][] curr = new long[_k + 1][3];
        long[][] next = new long[_k + 1][3];

        // Initialize all with mn
        for (int k = 0; k <= _k; k++) {
            for (int s = 0; s < 3; s++) {
                curr[k][s] = mn;
                next[k][s] = mn;
            }
        }

        // Base case: at day n
        for (int k = 0; k <= _k; k++) {
            next[k][0] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k <= _k; k++) {
                // State 0
                curr[k][0] = next[k][0];
                curr[k][0] = Math.max(curr[k][0], next[k][1] - prices[i]);
                curr[k][0] = Math.max(curr[k][0], next[k][2] + prices[i]);

                // States 1 and 2
                curr[k][1] = next[k][1];
                curr[k][2] = next[k][2];

                if (k > 0) {
                    curr[k][1] = Math.max(curr[k][1], next[k - 1][0] + prices[i]);
                    curr[k][2] = Math.max(curr[k][2], next[k - 1][0] - prices[i]);
                }
            }

            // Swap references
            long[][] temp = next;
            next = curr;
            curr = temp;
        }

        return next[_k][0];
    }
}