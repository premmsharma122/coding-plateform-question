class Solution {
    public boolean help(int V, ArrayList<ArrayList<Integer>> adj, int sen[], int path[], int i){
        sen[i] = 1;
        path[i] =1;
        
        for(int a : adj.get(i)){
            if(sen[a]==0){
                if(help(V,adj,sen,path,a)) return true;
            }else if(path[a]==1){
                return true;
            }
        }
        path[i]=0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int sen[] = new int[V];
        int path[] = new int[V];
        
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int a[] : edges){
            int u=a[0];
            int v = a[1];
            
            adj.get(u).add(v);
        }
        for(int i=0; i<V; i++){
            if(sen[i]==0){
                if(help(V,adj,sen,path,i)) return true;
            }
        }
        return false;
    }
}
