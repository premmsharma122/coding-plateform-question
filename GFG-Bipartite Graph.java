class Solution {
    public boolean help(int st, int V , ArrayList<ArrayList<Integer>> adj,int col[]){
        Queue<Integer> q = new LinkedList<>();
        col[st] = 0;
        q.add(st); 
        while(!q.isEmpty()){
            int curr = q.peek();
            q.remove();
            for(int a : adj.get(curr)){
                if(col[a]==-1){
                    col[a] = 1-col[curr];
                    q.add(a);
                    
                }else if(col[a]==col[curr]){
                    return false;
                }
            } 
        }
        return true;
        
    }
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int col[] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int ar[] : edges){
            int u = ar[0];
            int v= ar[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Arrays.fill(col,-1);
        for(int i=0; i<V; i++){
            if(col[i]==-1){
                if(!help(i,V,adj,col)) return false;
            }
        }
        return true;
    }
}
