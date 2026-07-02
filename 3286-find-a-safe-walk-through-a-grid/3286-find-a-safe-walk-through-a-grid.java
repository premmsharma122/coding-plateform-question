class Solution {
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, startHealth});

        int[][] best = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(best[i], -1);
        }
        best[0][0] = startHealth;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int h = cur[2];

            if (r == m - 1 && c == n - 1) return true;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {

                    int newHealth = h - grid.get(nr).get(nc);

                    if (newHealth > 0 && newHealth > best[nr][nc]) {
                        best[nr][nc] = newHealth;
                        q.add(new int[]{nr, nc, newHealth});
                    }
                }
            }
        }

        return false;
    }
}