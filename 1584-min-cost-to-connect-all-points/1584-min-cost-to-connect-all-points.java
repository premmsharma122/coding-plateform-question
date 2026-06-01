class Solution {
    class Pair{
        int n;
        int d;
        Pair(int n , int d){
            this.n=n;
            this.d=d;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
        for(int i=0; i<points.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2= points[j][0];
                int  y2= points[j][1];

                int dis = Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.get(i).add(new int[]{j,dis});
                adj.get(j).add(new int[]{i,dis});
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.d-b.d);
        pq.add(new Pair(0,0));
        boolean vis[] = new boolean[points.length];
        
        int c=0;
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int x = cur.n;
            int dis = cur.d;
            if(vis[x]){
                continue;
            }
            vis[x]=true;
            c+=dis;
            for(int a[] : adj.get(x)){
                int nd = a[0];
                int dist = a[1];
                if(!vis[nd]){
                    pq.offer(new Pair(nd,dist));
                }
            }
        }
        return c;

    }
}