class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] xCount = new int[m];
        int[] yCount = new int[m];
        int ans = 0;
        for(int i=0;i<n;i++){
            int x=0;
            int y = 0;
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){
                    xCount[j]++;
                }else if(grid[i][j]=='Y'){
                    yCount[j]++;
                }
                x += xCount[j];
                y += yCount[j];
                if(x==y && x>0){
                    ans++;
                }
            }
        }
        return ans;
    }
}