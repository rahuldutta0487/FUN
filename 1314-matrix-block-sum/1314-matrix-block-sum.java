class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] ans = new int[n][m];
            
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                for(int x =-K; x<=K;x++){
                    int nr = i+x; //new row

                    if(nr>=0 && nr<n){ //if row + k is in bound 

                    //first  find range of col
                    int left = Math.max(j-K,0);//col can't be negative
                    int right = j+K+1;
                    ans[nr][left] += mat[i][j]; //left bound
                    if(right<m) ans[nr][right] -=mat[i][j]; // right bound
                    }
                }
            }
        }
        
            int sum=0;
            for(int i=0;i<n;i++){
                sum=0;
                for(int j=0; j<m;j++){
                    sum += ans[i][j];
                    ans[i][j]=sum;
                }
            }

        return ans;
    }
}