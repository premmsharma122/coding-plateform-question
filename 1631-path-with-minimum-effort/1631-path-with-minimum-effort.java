class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        int[][] dir = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, 0, 0}); 
        res[0][0] = 0;

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int effort = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (x == n - 1 && y == m - 1) {
                return effort;
            }

            if (effort > res[x][y]) continue;

            for (int[] d : dir) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 &&
                    nx < n && ny < m) {

                    int diff = Math.abs(
                            heights[x][y] - heights[nx][ny]);

                    int newEffort =
                            Math.max(effort, diff);

                    if (newEffort < res[nx][ny]) {

                        res[nx][ny] = newEffort;

                        pq.add(new int[]{
                                newEffort,
                                nx,
                                ny
                        });
                    }
                }
            }
        }

        return 0;
    }
}