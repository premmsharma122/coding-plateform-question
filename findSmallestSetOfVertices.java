class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean deg[] = new boolean[n];
        for(List<Integer> a : edges){
            int u = a.get(0);
            int v = a.get(1);
            deg[v]=true;
        }
        List<Integer> c = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(deg[i]==false) c.add(i);
        }
        return c;
    }
}
