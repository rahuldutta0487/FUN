class DSU {
    int[] parent, rank, ands;
    int set_size;

    // Constructor initializes DSU
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        ands = new int[n];
        set_size = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initially, each node is its own parent
            rank[i] = 1;
            ands[i] = -1; // -1 indicates no AND value calculated yet
        }
    }

    // Find function with path compression
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Merging two components and updating the AND values
    void merge(int x, int y, int wt) {
        int xroot = find(x), yroot = find(y);
        if (xroot != yroot) {
            // Union by rank
            if (rank[xroot] >= rank[yroot]) {
                parent[yroot] = xroot;
                rank[xroot] += rank[yroot];
            } else {
                parent[xroot] = yroot;
                rank[yroot] += rank[xroot];
            }
            set_size--;

            // Updating the AND values of the component
            int toand = (ands[xroot] != -1 ? ands[xroot] : ands[yroot]);
            ands[xroot] = ands[yroot] = (toand == -1) ? wt : (toand & wt);
        } else {
            ands[xroot] &= wt; // Update the existing AND value
        }
    }

    // Returns the AND value for connected components, otherwise -1
    int solution(int x, int y) {
        return (find(x) == find(y)) ? ands[find(x)] : -1;
    }
}

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);

        // Merge all edges into DSU
        for (int[] edge : edges) {
            dsu.merge(edge[0], edge[1], edge[2]);
        }

        int[] ans = new int[query.length];
        // Answer each query
        for (int i = 0; i < query.length; i++) {
            ans[i] = dsu.solution(query[i][0], query[i][1]);
        }
        return ans;
    }
}