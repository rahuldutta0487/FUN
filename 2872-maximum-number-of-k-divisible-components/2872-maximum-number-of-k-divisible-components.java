class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Step 1: Build the tree using an adjacency list
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // Step 2: Initialize components counter
        int[] components = new int[1];

        // Step 3: Perform DFS
        dfs(0, -1, tree, values, k, components);

        // Step 4: Return the result
        return components[0];
    }

    long dfs(int node, int parent, ArrayList<ArrayList<Integer>> tree, int[] values, int k, int[] components) {
        long subTreeSum = values[node]; // Use long to avoid overflow

        // Traverse all children
        for (int neighbour : tree.get(node)) {
            if (neighbour != parent) {
                subTreeSum += dfs(neighbour, node, tree, values, k, components); // Accumulate subtree sums
            }
        }

        // Check divisibility
        if (subTreeSum % k == 0) {
            components[0]++; // Increment component count
            return 0; // Reset the subtree sum
        }

        return subTreeSum; // Return the subtree sum for the parent
    }
}