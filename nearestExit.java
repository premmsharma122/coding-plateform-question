class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1]});

        boolean[][] vis = new boolean[n][m];
        vis[entrance[0]][entrance[1]] = true;

        int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int ans = 0;

        while (!q.isEmpty()) {
            int s = q.size();

            while (s-- > 0) {
                int cur[] = q.poll();

                int r = cur[0];
                int c = cur[1];

                if ((r != entrance[0] || c != entrance[1]) &&
                    (r == 0 || r == n - 1 || c == 0 || c == m - 1)) {
                    return ans;
                }

                for (int a[] : dir) {
                    int nr = r + a[0];
                    int nc = c + a[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        maze[nr][nc] == '.' &&
                        !vis[nr][nc]) {

                        q.add(new int[]{nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }

            ans++;
        }

        return -1;
    }
}
