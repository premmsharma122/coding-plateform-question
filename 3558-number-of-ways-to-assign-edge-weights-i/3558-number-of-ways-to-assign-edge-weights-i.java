class Solution {
    private List<List<int[]>> e;
    private boolean[] vis;
    private int c;
    private final int MOD = 1_000_000_007;

    public void dfs(int x, int depth) {
        vis[x] = true;

        c = Math.max(c, depth);

        for (int[] a : e.get(x)) {
            int u = a[0];

            if (!vis[u]) {
                dfs(u, depth + 1);
            }
        }
    }

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        vis = new boolean[n + 1];
        c = 0;

        List<List<int[]>> g = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];

            g.get(u).add(new int[]{v, 1});
            g.get(v).add(new int[]{u, 1});
        }

        this.e = g;

        dfs(1, 0);   

        long res = 1;

        for (int i = 1; i < c; i++) {
            res = (res * 2) % MOD;
        }

        return (int) res;
    }
}