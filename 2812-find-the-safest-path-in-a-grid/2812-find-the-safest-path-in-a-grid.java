class Solution {
    int[][] distance;
    int M;
    int N;
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        this.M = grid.size();
        this.N = grid.get(0).size();
        this.distance = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        Queue<int[]> q1 = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int val = grid.get(i).get(j);
                if (val == 1) {
                    q1.add(new int[]{i, j, 0});
                    distance[i][j] = 0;
                }
            }
        }
        while (!q1.isEmpty()) {
            int[] cur = q1.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && cur[2] + 1 < distance[nx][ny]) {
                    q1.offer(new int[]{nx, ny, cur[2] + 1});
                    distance[nx][ny] = cur[2] + 1;
                }
            }
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[2] - a[2]); //<i, j, distance>
        int minDistance = distance[0][0];
        q.offer(new int[]{0, 0, minDistance});
        int res = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == M - 1 && y == N - 1) {
                return Math.min(distance[x][y], cur[2]);
            }
            cur[2] = Math.min(distance[x][y], cur[2]);
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny, Math.min(cur[2], distance[nx][ny])});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
}