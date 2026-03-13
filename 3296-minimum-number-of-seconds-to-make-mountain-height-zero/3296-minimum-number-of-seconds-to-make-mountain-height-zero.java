class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        int n = workerTimes.length;

        for (int i = 0; i < n; i++) {
            pq.offer(new long[]{workerTimes[i], i, 1});
        }

        long ans = 0;

        while (mountainHeight > 0) {

            long[] cur = pq.poll();

            long time = cur[0];
            int worker = (int)cur[1];
            long units = cur[2];

            ans = time;

            mountainHeight--;

            long nextTime = time + workerTimes[worker] * (units + 1);

            pq.offer(new long[]{nextTime, worker, units + 1});
        }

        return ans;
    }
}