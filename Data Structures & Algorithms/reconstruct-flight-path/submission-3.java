class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
               .offer(ticket.get(1));
        }

        LinkedList<String> res = new LinkedList<>();

        dfs("JFK", adj, res);

        return res;
    }

    private void dfs(String src,
                     Map<String, PriorityQueue<String>> adj,
                     LinkedList<String> res) {

        PriorityQueue<String> pq = adj.get(src);

        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, adj, res);
        }

        res.addFirst(src);
    }
}