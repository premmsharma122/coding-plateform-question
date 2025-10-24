class Solution {
    public boolean help(int i, boolean seen[],int v,List<List<Integer>> adj){
        int par[] = new int[v];
        Arrays.fill(par,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        seen[i] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int n : adj.get(cur)){
                if(!seen[n]){
                seen[n] =true;
                q.add(n);
                par[n] = cur;
                }else if(par[cur]!= n){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean sen[] = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u); 
        }

        for(int i=0; i<V; i++){
            if(!sen[i]){
                if(help(i,sen,V,adj)){
                    return false;
                }
            }
        }
        return true;
        
    }
}
