class Solution {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent)
            return;

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        // Add original index to every query
        int[][] newQueries = new int[queries.length][4];

        for (int i = 0; i < queries.length; i++) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = queries[i][2];
            newQueries[i][3] = i;
        }

        // Sort edges and queries by weight/limit
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(newQueries, (a, b) -> a[2] - b[2]);

        boolean[] result = new boolean[queries.length];

        int j = 0;

        for (int[] query : newQueries) {

            int u = query[0];
            int v = query[1];
            int w = query[2];
            int idx = query[3];

            while (j < edgeList.length && edgeList[j][2] < w) {
                union(edgeList[j][0], edgeList[j][1]);
                j++;
            }

            result[idx] = find(u) == find(v);
        }

        return result;
    }
}
