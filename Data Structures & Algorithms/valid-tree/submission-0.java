class Solution {
    public boolean validTree(int n, int[][] edges) {

    boolean[] visited = new boolean[n];

    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++)
        adj.add(new ArrayList<>());

    for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }

    if (!dfs(0, -1, visited, adj))
        return false;

    for (boolean v : visited) {
        if (!v)
            return false;
    }

    return true;
}

    public boolean dfs(int node, int parent, boolean[] visited,
            List<List<Integer>> adj) {

        visited[node] = true;

        for (int nei : adj.get(node)) {

            if (nei == parent)
                continue;

            if (!visited[nei]) {
                if (!dfs(nei, node, visited, adj))
                    return false;
            } else {
                return false; // cycle found
            }
        }

        return true;
    }


}