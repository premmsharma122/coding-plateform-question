class Solution {
    public class Edge{
        int src, dest;
        Edge(int src , int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        ArrayList<Edge>[] g = new ArrayList[graph.length];
        for(int i=0; i<graph.length; i++) g[i]=new ArrayList<>();
        for(int i=0; i<graph.length; i++){
           for(int gr : graph[i]){
            g[i].add(new Edge(i,gr));
           }
        }
        int clr[] = new int[graph.length];
        Arrays.fill(clr,-1);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<g.length; i++){
            if(clr[i]==-1){
                clr[i]=0;
                q.add(i);
                while(!q.isEmpty()){
                    int cur = q.remove();
                    for(int j=0; j<g[cur].size(); j++){
                        Edge e = g[cur].get(j);
                        if(clr[e.dest]==-1){
                            int nxt = clr[cur]==1?0:1;
                            clr[e.dest]=nxt;
                            q.add(e.dest);
                        }else if(clr[e.dest]==clr[cur]){
                            return false;
                        }
                    }
                }
            }
        }    
            return true;
    }
}