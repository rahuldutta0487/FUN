class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length ; 
        int n = grid[0].length ;
        int ans[][] = new int[m-k+1][n-k+1] ;
        for (int i = 0 ; i <= m-k ; i++ ) {
            for (int j = 0 ; j <= n-k ; j++ ) {
                TreeSet<Integer> set = new TreeSet<>() ; 
                for (int a = i ; a < i+k ; a++ ) {
                    for (int b = j ; b < j+k ; b++ ) {
                        set.add(grid[a][b]) ; 
                    }
                }
                List<Integer> list = new ArrayList<>(set) ; 
                int min = Integer.MAX_VALUE ; 
                if (list.size() >= 2) {
                    for (int x = 0; x < list.size() - 1; x++) {
                        min = Math.min(min, Math.abs(list.get(x + 1) - list.get(x)));
                    }
                }else {
                    min = 0 ; 
                    
                }
                ans[i][j] = min ; 
            }
        }
        return ans ;
    }
}