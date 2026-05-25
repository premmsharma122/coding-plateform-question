class Solution {
    static int par[];
    static int rank[];
    public static int find(int x){
        if(x==par[x]) return x;
        return par[x] = find(par[x]);
    }
    public static void union(int x, int y){
        int x_pr = find(x);
        int y_pr = find(y);
        if(x_pr==y_pr) return;
        if(rank[x_pr]>rank[y_pr]){
            par[y_pr]=x_pr;
        }else if(rank[x_pr]<rank[y_pr]){
            par[x_pr]=y_pr;
        }else{
            par[x_pr]=y_pr;
            rank[y_pr]++;
        }
    }

    public long countPairs(int n, int[][] edges) {
        par = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            par[i]=i;
        }

        for(int a[] : edges){
            int x= a[0];
            int y = a[1];
            union(x,y);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            int x = find(i);
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        long ans =0;
        long rem = n;
        for(int a : hm.keySet()){
            int size = hm.get(a);
            ans +=(long) (size)*(rem-size);
            rem-=size;
        }
        return ans;
    }
}