class Solution {
    public  boolean help(String s1, String s2){
        int c=0;
        if(s1.length()!=s2.length()) return false;
        int n=s1.length();
        for(int i=0; i<n; i++){
            if(s1.charAt(i)!=s2.charAt(i)) c++;
        }
        return c<=2;
    }
    public void dfs(ArrayList<ArrayList<Integer>> g , String str[], int cur, boolean vis[]){
        vis[cur]=true;
        for(int a : g.get(cur)){
            if(!vis[a]){
                dfs(g,str,a,vis);
            }
        }
    }
    public int numSimilarGroups(String[] strs) {
        // 1. adj list for strings
        // 2. for create adj connext them as if they similar ( only 2 diff char)
        // 3. Now perfrom dfs for that adj.
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int n=strs.length;
        for(int i=0; i<n; i++){
            g.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(help(strs[i],strs[j])){
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }
        int c=0;
        boolean vis[] = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(g,strs,i,vis);
                c++;
            }
        }
        return c;
    }
}
