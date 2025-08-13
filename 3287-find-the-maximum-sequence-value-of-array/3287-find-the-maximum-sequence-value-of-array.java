class Solution {
    public int maxValue(int[] nums, int k) {
        
        int n = nums.length;
        boolean dp[][][] = new boolean[n][k+2][1 << 7+1];

        dp[0][1][nums[0]] = true;
        
        for(int i = 1; i < n; i++) {
            dp[i][1][nums[i]] = true;
            for(int j = 1; j <= 128; j++) {
                for(int a = 1; a <= k; a++) {
                    if ( dp[i-1][a][j] ) {
                        dp[i][a+1][j|nums[i]] = true;
                        dp[i][a][j] = true;
                    }
                }
            }
        }

        boolean dp2[][][] = new boolean[n][k+2][1 << 7+1];
        dp2[n-1][1][nums[n-1]] = true;
        
        for(int i = n-2; i >= 0; i--) {
            dp2[i][1][nums[i]] = true;
            for(int j = 1; j <= 128; j++) {
                for(int a = 1; a <= k; a++) {
                    if ( dp2[i+1][a][j]) {
                        dp2[i][a+1][j|nums[i]] = true;
                        dp2[i][a][j] = true;
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            if ( i+1 >= k && n-(i+1) >= k) {
                for(int a = 1; a <= 128; a++) {
                    for(int b = 1; b <= 128; b++) {
                        if ( dp[i][k][a] && dp2[i+1][k][b] ) {
                            max = Math.max(max, a^b);
                        }
                        
                    }
                }
            }
        }     
        return max;
    }
}