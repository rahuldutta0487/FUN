class Solution {
    public double soupServings(int n) {
       if(n>=4300) return 1.0;
       int ns=(n+24)/25;
       return serve(ns,ns,new double[ns+1][ns+1]);
    }
    private double serve(int a,int b,double dp[][]){
        if(a<=0 && b<=0) return 0.5;
        if(b<=0) return 0.0;
        if(a<=0) return 1.0;
        if(dp[a][b]>0) return dp[a][b];
        return dp[a][b] = 0.25 * (serve(a - 4, b, dp)     + serve(a - 3, b - 1, dp) + 
                                  serve(a - 2, b - 2, dp) + serve(a - 1, b - 3, dp));
    }
}