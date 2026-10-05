class Solution {
    static int ans=Integer.MIN_VALUE;
    public void dfs(ArrayList<ArrayList<Integer>> g, int e[],int cur, boolean vis[], boolean rec[], int dis[] ){
        if(cur!=-1){
            vis[cur]=true;
            rec[cur]=true;
            int next = e[cur];
            if(next!=-1 && !vis[next]){
                dis[next] = dis[cur]+1;
                dfs(g,e,next,vis,rec,dis);

            }else if(next!=-1 && rec[next]){
                ans=Math.max(ans, dis[cur]-dis[next]+1);
            }
        }
        rec[cur]= false;
    }
    public int longestCycle(int[] edges) {
        // 1. dfs
        // 2. Go for each node and do dfs and count for node -> dfs-> if cycle( vis- true-> store max(count ,max))
        int n=edges.length;
        ans=Integer.MIN_VALUE;
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i=0; i<n; i++){
            g.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            if(edges[i]!=-1){
                g.get(i).add(edges[i]);
            }
        }
        int dis[] = new int[n];
        boolean vis[] = new boolean[n];
        boolean rec[] = new boolean[n];
        Arrays.fill(dis,1);
        for(int i=0;i<n; i++){
            dfs(g,edges,i,vis,rec,dis);
        }
        return ans==Integer.MIN_VALUE?-1:ans;
    }
}
