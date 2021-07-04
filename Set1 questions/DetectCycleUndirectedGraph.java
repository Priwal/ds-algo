class Solution {

    Boolean isCyclicUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {

        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj.get(v).iterator();

        while (it.hasNext()) {
            i = it.next();

            if (!visited[i]) {
                if (isCyclicUtil(i, adj, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }

        }

        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}