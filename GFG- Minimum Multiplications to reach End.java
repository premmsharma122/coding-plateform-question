// User function Template for Java

import java.util.*;

class Solution {
    static final int MOD = 100000;

    int minimumMultiplications(int[] arr, int start, int end) {
        // अगर start == end है तो कोई step नहीं चाहिए
        if (start == end) return 0;

        // distance array: हर number तक पहुंचने के लिए minimum steps
        int[] dist = new int[MOD];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int num : arr) {
                int next = (int)((curr * 1L * num) % MOD);

                // अगर हमने इसे पहले नहीं देखा
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;

                    // अगर destination मिल गया
                    if (next == end) return dist[next];

                    q.offer(next);
                }
            }
        }

        // अगर कभी end नहीं मिला
        return -1;
    }
}
