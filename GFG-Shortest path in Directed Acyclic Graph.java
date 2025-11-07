class Pair {
    int f, wt;
    Pair(int f, int wt) {
        this.f = f;
        this.wt = wt;
    }
}

class Solution {
    public void help(int cur, ArrayList<ArrayList<Pair>> adj, int[] sen, Stack<Integer> st) {
        sen[cur] = 1;
        for (Pair p : adj.get(cur)) {
            if (sen[p.f] == 0) {
                help(p.f, adj, sen, st);
            }
        }
        st.push(cur);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int[] sen = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (sen[i] == 0) {
                help(i, adj, sen, st);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!st.isEmpty()) {
            int cur = st.pop(); 
            for (Pair p : adj.get(cur)) {
                if (dist[cur] != Integer.MAX_VALUE && dist[cur] + p.wt < dist[p.f]) {
                    dist[p.f] = dist[cur] + p.wt; 
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }
}
