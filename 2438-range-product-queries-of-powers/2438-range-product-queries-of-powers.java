class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1_000_000_007;

        List<Long> powers = new ArrayList<>();
        for(int i=0; i<31; i++)
        {
            if(((n >> i) & 1) == 1)
            {
                powers.add(1L << i);
            }
        }

        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++)
        {
            int L = queries[i][0];
            int R = queries[i][1];
            long prod = 1;

            for(int j=L; j<=R; j++)
            {
                prod = (prod * powers.get(j)) % MOD;
            }
            ans[i] = (int) prod; 
        }
        return ans;
    }
}