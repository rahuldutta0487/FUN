class Solution {
    int rl ;
    int cl ;
    public int cherryPickup(int[][] grid) {
        rl = grid.length;
        cl = grid[0].length;
        int[][][][]dp = new int[rl][rl][cl][cl];
        for(int[][][] a3 : dp){
            for(int[][] a2 : a3){
                for(int[] a1 : a2)Arrays.fill(a1,-2);
            }
        }
        int ret = pass(grid , dp , 0 , 0 , 0 , 0);
        if(ret < 0)return 0;
        return ret;
    }
    int pass(int[][] grid , int[][][][]dp , int r1 , int r2 , int c1 , int c2){
        if(c1 == cl || c2 == cl || r1 == rl || r2 == rl)return -1;
        if(dp[r1][r2][c1][c2] != -2)return dp[r1][r2][c1][c2];
        if(c1 == cl-1 && c2 == cl-1 && r1 == rl-1 && r2 == rl-1)return dp[r1][r2][c1][c2] = grid[r1][r2];
        if(grid[r1][c1]==-1 || grid[r2][c2] == -1)return dp[r1][r2][c1][c2] = -1;
        // if(dp[r1][r2][c1][c2] != 2)return dp[r1][r2][c1][c2];
        int cur =grid[r1][c1];
        if(r1 != r2 && c1 != c2)cur += grid[r2][c2];
        int max = -2;
        max = Math.max(max , pass(grid , dp , r1+1 , r2+1 , c1 , c2));
        max = Math.max(max , pass(grid , dp , r1 , r2 , c1+1 , c2+1));
        max = Math.max(max , pass(grid , dp , r1+1 , r2 , c1 , c2+1));
        max = Math.max(max , pass(grid , dp , r1 , r2+1 , c1+1 , c2));
        if(max > -1) return dp[r1][r2][c1][c2] = cur + max;
        return dp[r1][r2][c1][c2] = -1;
    }
}