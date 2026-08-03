class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];
        Arrays.fill(visited, false);
        Arrays.fill(recPath, false);

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCycleDFS(i, prerequisites, visited, recPath))
                    return new int[] {};

            }
        }
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                topologicalSort(i, prerequisites, visited, stack);
            }
        }
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;

    }

    public void topologicalSort(int src, int[][] prerequisites, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            if (u == src) {
                if (!visited[v]) {
                    topologicalSort(v, prerequisites, visited, stack);
                }
            }

        }
        stack.push(src);
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