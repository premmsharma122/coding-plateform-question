class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(new ArrayList<>());
        }
        for(int r[] : roads){
            int u = r[0], v= r[1], t =r[2];
            arr.get(u).add(new int[]{v,t});
            arr.get(v).add(new int[]{u,t});
        }
        long dis[] = new long[n];
        int ways[] = new int[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] =0;
        ways[0]=1;
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        q.offer(new long[]{0,0});
        int MOD = 1_000_000_007;
        while(!q.isEmpty()){
            long curr[] = q.poll();
            long d = curr[0];
            int node = (int ) curr[1];
            if(d>dis[node]) continue;
            for(int ng[] : arr.get(node)){
                int nxt = ng[0];
                int time = ng[1];
                if(dis[node] + time < dis[nxt]){
                    dis[nxt] = dis[node] +time;
                    ways[nxt] = ways[node];
                    q.offer(new long[]{dis[nxt],nxt});

                }else if(dis[node] + time == dis[nxt]){
                    ways[nxt ] = (ways[nxt] + ways[node])%MOD;
                }
            }
        }
        return ways[n-1];
    }
}
