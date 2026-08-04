class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            boolean[] visited = new boolean[n + 1];
            if (iscycledfs(edge[0], -1, adj, visited))
                return edge;
        }
        return new int[0];
    }

    public boolean iscycledfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == parent)
                continue;
            if (!visited[nei]) {
                if (iscycledfs(nei, node, adj, visited))
                    return true;
            } else
                return true;
        }

        return false;
    }
}
