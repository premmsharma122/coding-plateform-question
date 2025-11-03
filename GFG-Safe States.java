class Solution {
    public boolean help(int i, ArrayList<ArrayList<Integer>> adj, int sen[],int path[], int ch[]){
        sen[i] = 1;
        ch[i]  =0;
        path[i] =1;
        for(int a : adj.get(i)){
            if(sen[a]==0){
                if(help(a,adj,sen,path,ch)) return true;
               
            }
             else if(path[a]==1)  return true;
        }
        ch[i] =1;
        path[i] = 0;
        return false;
    }
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        int sen[] = new int[V];
        int path[] = new int[V];
        int ch[] = new int[V];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
        }
        for(int i=0; i<V; i++){
            if(sen[i]==0){
                help(i,adj,sen,path,ch);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(ch[i]==1) ans.add(i);
        }
        return ans;
        
        
    }
}
