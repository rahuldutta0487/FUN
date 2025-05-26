class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int[][] adj = new int[n+1][n+1];
        int[] degree = new int[n+1];
       for(int[] edge : edges){
           int x = edge[0];
           int y = edge[1];
           
           adj[x][y] = 1;
           adj[y][x] = 1;
           
           degree[x]++;
           degree[y]++;
       }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i<=n; i++){
            for(int j = i+1; j<=n; j++){
                if(adj[i][j] != 1)
                    continue;
                for(int k = j+1; k<=n; k++){
                    if(adj[i][k] == 1 && adj[j][k] == 1){
                        ans = Math.min(ans, degree[i] + degree[j] + degree[k] - 6);
                    }
                }
            }
        }
        
        if(ans == Integer.MAX_VALUE)
            return -1;
        else 
            return ans;
    }
}