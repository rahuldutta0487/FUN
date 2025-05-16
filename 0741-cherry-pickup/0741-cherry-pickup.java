class Solution {
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        
        int dp[][][][] = new int[n][n][n][n];
        
        int res = pickup(grid , 0  , 0 , 0 , 0 , dp);
        return (res < 0) ? 0 : res;
    }
    
    public int pickup(int grid[][] , int pr1 ,int pc1 , int pr2 ,int pc2,int dp[][][][]) {
        if(pr1 >= grid.length || pr2 >= grid.length || pc1 >= grid[0].length || pc2 >= grid[0].length || grid[pr1][pc1] == -1 || grid[pr2][pc2] == -1) {
            return Integer.MIN_VALUE;
            // we want maximum value so returning min value here
        }
        
        int ans = 0;
        
        if(pr1 == grid.length-1 && pc1 == grid[0].length-1) {
            return grid[pr1][pc1];
        }
        
        if(dp[pr1][pr2][pc1][pc2] != 0) {
            return dp[pr1][pr2][pc1][pc2];
        }
        
        if(pr1 == pr2 && pc1 == pc2) {
            ans += grid[pr1][pc1];
        }
        else {
            ans += grid[pr1][pc1] + grid[pr2][pc2];
        }
        
        int f1 = pickup(grid , pr1+1 , pc1 , pr2+1 , pc2 , dp); // v , v
        int f2 = pickup(grid , pr1 , pc1+1 , pr2 , pc2+1 ,dp); 
        int f3 = pickup(grid , pr1+1 , pc1 , pr2 , pc2+1,dp);
        int f4 = pickup(grid , pr1 , pc1+1 , pr2+1 , pc2,dp);
        
        ans += Math.max( Math.max(f1 , f2) , Math.max(f3 , f4) );
        dp[pr1][pr2][pc1][pc2] = ans;
        
        return ans;
        
    }
}