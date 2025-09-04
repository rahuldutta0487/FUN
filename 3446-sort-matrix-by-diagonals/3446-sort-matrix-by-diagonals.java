class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int i=0,k=grid[0].length-1;
        int j;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        while(k>0){
             j=k;
             i=0;
             while(i<grid.length && j<grid[0].length){
                pq.offer(grid[i][j]);
                i++;j++;
             }
             j=k;
             i=0;
             while(i<grid.length && j<grid[0].length){
                grid[i][j]=pq.poll();
                i++;j++;
             }
             k--;
        }

        k=0;
        pq=new PriorityQueue<>(Collections.reverseOrder());
        while(k<grid.length){
            i=k;
            j=0;
            while(i<grid.length && j<grid[0].length){
                pq.add(grid[i][j]);
                i++;
                j++;
            }
            i=k;j=0;
            while(i<grid.length && j<grid[0].length){
                grid[i][j]=pq.poll();
                i++;
                j++;
            }
            k++;
        }

        return grid;
    }
}