class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] cache = new int[n+1][101][];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                int[] tmp = new int[101];
                Arrays.fill(tmp, -1);
                cache[i][j] = tmp;
            }
        }
        
        return dp(n, 0, 0, minProfit, group, profit, (int) (Math.pow(10, 9) + 7), cache);
    }

    public static int dp(int n_remain, int start_i, int gain, int minProfit, int[] group, int[] profit, int mod, int[][][] cache) {
        if (n_remain < 0) return 0;
        
        if (cache[n_remain][start_i][gain] != -1) return cache[n_remain][start_i][gain];

        int poss = gain >= minProfit ? 1 : 0;

        if (start_i == group.length) return poss;

        for (int take = start_i; take < group.length; take++) {
            int tmp = gain + profit[take];
            tmp = tmp > 100 ? 100 : tmp;
            poss = (poss + dp(n_remain - group[take], take + 1, tmp, minProfit, group, profit, mod, cache) % mod) % mod;
        }

        cache[n_remain][start_i][gain] = poss;

        return poss;

    }
}