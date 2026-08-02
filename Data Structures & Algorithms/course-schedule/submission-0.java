class Solution {
   public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];
        Arrays.fill(visited, false);
        Arrays.fill(recPath, false);

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCycleDFS(i, prerequisites, visited, recPath))
                    return false;
            }
        }
        return true;
    }

    public boolean isCycleDFS(int src, int[][] prerequisites, boolean[] visited, boolean[] recPath) {
        visited[src] = true;
        recPath[src] = true;
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            if (u == src) {
                if (!visited[v]) {
                    if (isCycleDFS(v, prerequisites, visited, recPath))
                        return true;

                } else if (recPath[v]) {
                    return true;

                }
            }

        }
        recPath[src] = false;
        return false;
    }
}
