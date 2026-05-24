class Solution {
    static int par[];
    static int rank[];
    static int find(int x){
        if(x==par[x]) return x;
        return par[x] = find(par[x]);
    }
    static void union(int x ,int y){
        int x_pr = find(x);
        int y_pr = find(y);
        if(x_pr==y_pr) return;
        if(rank[x_pr]>rank[y_pr]){
            par[y_pr] = x_pr;
        }else if(rank[x_pr]<rank[y_pr]){
            par[x_pr]=y_pr;
        }else{
            par[x_pr]=y_pr;
            rank[y_pr]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        par= new int[n];
        rank= new int[n];
        if(connections.length< n-1) return -1;
        for(int i=0; i<n; i++){
            par[i]=i;
        }
        int c=n;
        for(int a[] : connections){
            int x= a[0];
            int y=a[1];
            int x_pr = find(x);
            int y_pr = find(y);
            if(x_pr != y_pr){
                union(x,y);
                c--;
            }
        }
        return c-1;
    }
}