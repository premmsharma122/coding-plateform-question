class Solution {
    public void dfs(int i, List<List<Integer>> g, boolean sen[], ArrayList<Integer> comp){
        comp.add(i);
        sen[i] =true;
        for(int a : g.get(i)){
            if(!sen[a]){
                dfs(a,g,sen,comp);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0; i<n; i++){
            g.add(new ArrayList<>());
        }
        for(int a[] : edges){
            int u = a[0];
            int v = a[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        boolean sen[] = new boolean[n];
        int ans=0;
        for(int i=0; i<n; i++){
            ArrayList<Integer> comp = new ArrayList<>();
            if(!sen[i]){
                dfs(i,g,sen,comp);
                int k = comp.size();
                int exc = k*(k-1)/2;
                int act=0,m=0;
                for(int a : comp ){
                    m +=g.get(a).size();
                }
                act=m/2;
                if(exc==act)ans++;
            }
        }
        return ans;

    }
}