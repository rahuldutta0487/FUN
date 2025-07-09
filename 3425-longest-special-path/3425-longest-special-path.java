class Solution {
    ArrayList<int[]>[] adj;
    int n;
    int[] nums;
    int[] dist;
    int[] lastOccur;
    ArrayList<Integer> pathStack;
    int minIndex;
    int maxLen;
    int minNodesForMaxLen;
    
    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }
        
        dist = new int[n];
        buildDist(0, -1, 0);
        
        int maxVal = 0;
        for (int val : nums) {
            if (val > maxVal) {
                maxVal = val;
            }
        }
        lastOccur = new int[maxVal + 1];
        Arrays.fill(lastOccur, -1);
        
        pathStack = new ArrayList<>();
        minIndex = 0;
        maxLen = 0;
        minNodesForMaxLen = Integer.MAX_VALUE;
        
        dfs(0, -1);
        
        return new int[]{maxLen, minNodesForMaxLen};
    }
    
    public void buildDist(int u, int parent, int currDist) {
        dist[u] = currDist;
        for(int[] edge : adj[u]) {
            int v = edge[0], w = edge[1];
            if (v == parent) continue;
            buildDist(v, u, currDist + w);
        }
    }
    
    public void dfs(int u, int parent) {
        int stackPos = pathStack.size();
        pathStack.add(u);
        
        int val = nums[u];
        int oldPos = lastOccur[val];
        int oldMinIndex = minIndex;
        
        lastOccur[val] = stackPos;
        
        if(oldPos >= minIndex) {
            minIndex = oldPos + 1;
        }
        
        if(minIndex <= stackPos) {
            int ancestor = pathStack.get(minIndex);
            int pathLength = dist[u] - dist[ancestor];
            int pathNodes = stackPos - minIndex + 1;
            
            if(pathLength > maxLen) {
                maxLen = pathLength;
                minNodesForMaxLen = pathNodes;
            } else if (pathLength == maxLen && pathNodes < minNodesForMaxLen) {
                minNodesForMaxLen = pathNodes;
            }
        }
        
        for(int[] edge : adj[u]) {
            int v = edge[0], w = edge[1];
            if (v == parent) continue;
            dfs(v, u);
        }
        
        pathStack.remove(pathStack.size() - 1);
        lastOccur[val] = oldPos;
        minIndex = oldMinIndex;
    }
}