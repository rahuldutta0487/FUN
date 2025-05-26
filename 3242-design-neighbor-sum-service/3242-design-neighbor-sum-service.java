class NeighborSum {
    private final int[][] idx, grid;
    private final int n;

    public NeighborSum(final int[][] grid) {
        this.n = grid.length;

        this.grid = grid;
        this.idx = new int[n * n][2];

        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                idx[grid[i][j]] = new int[] { i, j };
    }
    
    public int adjacentSum(final int value) {
        final int[] indexes = idx[value];
        final int i = indexes[0], j = indexes[1];

        int sum = 0;

        if(i + 1 < n && i + 1 >= 0)
            sum += grid[i + 1][j];

        if(i - 1 < n && i - 1 >= 0)
            sum += grid[i - 1][j];

        if(j + 1 < n && j + 1 >= 0)
            sum += grid[i][j + 1];

        if(j - 1 < n && j - 1 >= 0)
            sum += grid[i][j - 1];

        return sum;
    }
    
    public int diagonalSum(final int value) {
        final int[] indexes = idx[value];
        final int i = indexes[0], j = indexes[1];

        int sum = 0;

        if(i + 1 < n && i + 1 >= 0 && j + 1 < n && j + 1 >= 0)
            sum += grid[i + 1][j + 1];

        if(i - 1 < n && i - 1 >= 0 && j - 1 < n && j - 1 >= 0)
            sum += grid[i - 1][j - 1];

        if(i + 1 < n && i + 1 >= 0 && j - 1 < n && j - 1 >= 0)
            sum += grid[i + 1][j - 1];

        if(i - 1 < n && i - 1 >= 0 && j + 1 < n && j + 1 >= 0)
            sum += grid[i - 1][j + 1];

        return sum;
    }
}