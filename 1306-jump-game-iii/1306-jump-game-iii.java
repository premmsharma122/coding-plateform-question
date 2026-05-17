class Solution {
    public boolean dfs(int a[], boolean vis[], int s){
        if(s<0 || s>=a.length) return false;
        if(vis[s]) return false;
        if(a[s]==0) return true;
        vis[s]=true;
        boolean left  = s-a[s]>=0?dfs(a,vis,s-a[s]):false;
        boolean right = dfs(a,vis,s+a[s]);
        if(left || right) return true;
        return false;

    }
    public boolean canReach(int[] arr, int start) {
        boolean vis[] = new boolean[arr.length];
        return dfs(arr,vis,start);
    }
}