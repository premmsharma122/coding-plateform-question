class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int a[] : times){
            int u= a[0];
            int v= a[1];
            int w  =a[2];
            adj.get(u).add(new int[]{v,w});
            
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int dis[]= new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int node = cur[0];
            int wt  = cur[1];
            if(wt > dis[node]) continue;

            for(int e[] : adj.get(node)){
                int nd  = e[0];
                int d = e[1];
                if(d + dis[node] < dis[nd]){
                    dis[nd]= d + dis[node];
                    pq.add(new int[]{nd,dis[nd]});
                }
            }
        }
        int res = 0;
        for(int i=1; i<=n; i++){
            res = Math.max(res, dis[i]);
        }
        return res == Integer.MAX_VALUE?-1: res;
    }
}