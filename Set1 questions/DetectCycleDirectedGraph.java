class Solution {
    // Function to detect cycle in a directed graph.
    boolean CyclePresent(boolean[] visited, boolean[] recStack, int v, ArrayList<ArrayList<Integer>> adj) {
        if (recStack[v])
            return true;

        if (visited[v])
            return false;

        visited[v] = true;
        recStack[v] = true;

        ArrayList<Integer> children = adj.get(v);

        for (Integer c : children) {
            if (CyclePresent(visited, recStack, c, adj))
                return true;
        }
        recStack[v] = false;
        return false;

    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (CyclePresent(visited, recStack, i, adj))
                return true;
        }
        return false;

    }
}