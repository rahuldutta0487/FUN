class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int[] arr=new int[n*n+1]; // 1D board mapping
        boolean lr=true; // left-to-right toggle
        int idx=1;

        // Flatten the board into 1D (Boustrophedon order)
        for(int i=n-1;i>=0;i--) {
            if(lr) {
                for(int j=0;j<n;j++) arr[idx++]=board[i][j];
            } else {
                for(int j=n-1;j>=0;j--) arr[idx++]=board[i][j];
            }
            lr=!lr;
        }

        boolean[] vis=new boolean[n*n+1];
        Queue<Integer> que=new LinkedList<>();
        que.offer(1);
        vis[1]=true;
        int res=0; // moves

        // BFS to find shortest path to end
        while(!que.isEmpty()) {
            int size=que.size();
            for(int k=0;k<size;k++) {
                int cur=que.poll();
                if(cur==n*n) return res; // reached the last square

                for(int i=cur+1;i<=Math.min(cur+6,n*n);i++) { // Try all dice moves (1–6)
                    int d=arr[i]==-1 ? i : arr[i]; // Jump if ladder/snake
                    if(!vis[d]) {
                        vis[d]=true;
                        que.offer(d);
                    }
                }
            }
            res++;
        }

        return -1; // Not reachable
    }
}