```java
class Solution {
    public int BFS(int u, HashMap<Integer, ArrayList<Integer>> adj) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();

        que.offer(u);
        visited.add(u);

        while (!que.isEmpty()) {
            int temp = que.poll();

            for (int v : adj.getOrDefault(temp, new ArrayList<>())) {
                if (!visited.contains(v)) {
                    que.offer(v);
                    visited.add(v);
                }
            }
        }

        return visited.size();
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long distance = (x2 - x1) * (x2 - x1)
                               + (y2 - y1) * (y2 - y1);

                if (r1 * r1 >= distance) {
                    adj.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int count = BFS(i, adj);
            result = Math.max(result, count);
        }

        return result;
    }
}
```
