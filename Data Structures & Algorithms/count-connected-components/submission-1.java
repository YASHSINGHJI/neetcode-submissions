class Solution {
          public int countComponents(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        int count = 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < adj.size(); i++) {
            if(!visited[i]){
            count++;
            dfs(i, visited, adj);
            }
        }
        return count;

    }

    public void dfs(int node, boolean[] visited,
            List<List<Integer>> adj) {

        visited[node] = true;

        for (int nei : adj.get(node)) {

            if (!visited[nei]) {
                dfs(nei, visited, adj);

            }
        }

    }
}
