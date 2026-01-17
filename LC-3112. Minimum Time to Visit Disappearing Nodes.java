class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] g =new ArrayList[n];
         for (int i = 0; i < n; i++){
             g[i] = new ArrayList<>();
         } 

            for(int e[] : edges){
                int u=e[0], v=e[1], w=e[2];
                g[u].add(new int[]{v,w});
                g[v].add(new int[]{u,w});
            }
        
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        if(0>=disappear[0]) return new int[n];

        pq.add(new int[]{0,0});
        dist[0] = 0;
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int time = cur[0];
            int node = cur[1];
            if(time> dist[node]) continue;
            for(int ng[] : g[node]){
                int nxt  = ng[0];
                int w  = ng[1];
                int newt = time+w;
                if (newt >= disappear[nxt]) continue;
                if(newt<dist[nxt]){
                    dist[nxt]  = newt;
                    pq.offer(new int[]{newt,nxt});
                }
            }
        }
        for(int i=0;i<n; i++){
            if(dist[i]==Integer.MAX_VALUE) dist[i]=-1;
        }
        return dist;

    }
}
