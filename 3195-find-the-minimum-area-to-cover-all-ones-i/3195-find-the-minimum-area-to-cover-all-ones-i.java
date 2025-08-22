class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int top_min = Integer.MAX_VALUE , bottom_max = 0 , left_min = Integer.MAX_VALUE, right_max = 0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
               if(grid[i][j] == 1)
               {
                 top_min = Math.min(i,top_min);
                 bottom_max = Math.max(bottom_max,i);
                 left_min = Math.min(j,left_min);
                 right_max = Math.max(j,right_max);
               } 
            }
        }
        return (bottom_max - top_min + 1) * (right_max - left_min + 1);
    }
}