class Solution {
    public class Edge{
        int src;
        int dest;
        Edge(int src , int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public boolean cycle(List<Edge>[] g , boolean seen[], boolean st[], int src){
        seen[src] = true;
        st[src] = true;
        for(int i=0; i<g[src].size(); i++){
            Edge e = g[src].get(i);
            if(st[e.dest]) return true;
            else if (!seen[e.dest] && cycle(g,seen,st,e.dest)) return true;
        }
        st[src] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean seen[] = new boolean[numCourses];
        boolean st[] = new boolean[numCourses];
        List<Edge>[] g = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            g[i] = new ArrayList<>();
        }
        for(int a[] : prerequisites){
            int u = a[0];
            int v =a[1];
            g[u].add(new Edge(u,v));
        }
        for(int i=0; i<numCourses; i++){
            if(!seen[i]){
                if(cycle(g,seen,st,i)){
                    return false;
                }
            }
        }
        return true;
    }
}