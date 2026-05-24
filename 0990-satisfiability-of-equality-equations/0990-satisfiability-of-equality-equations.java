class Solution {
    public static int par[];
    public static int rank[];
    public static int find(int x){
        if(x==par[x]) return x;
        return par[x] = find(par[x]);
    }
    public static void union(int x, int y){
        int x_pr = find(x);
        int y_pr = find(y);
        if(x_pr==y_pr) return;
        if(rank[x_pr]>rank[y_pr]){
            par[y_pr]= x_pr;
        }
        else if(rank[y_pr] > rank[x_pr]){
            par[x_pr]=y_pr;
        }else{
            par[x_pr]=y_pr;
            rank[y_pr]++;
        }
    }
    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        rank = new int[26];
        for(int i=0; i<26; i++){
            par[i]=i;
        }
        for(String s : equations){
            if(s.charAt(1)=='='){
                union(s.charAt(0)-'a', s.charAt(3)-'a');
            }
        }
         for(String s : equations){
            if(s.charAt(1)=='!'){
                int x= find(s.charAt(0)-'a');
                int y= find(s.charAt(3)-'a');
                if(x==y) return false;
            }
        }
        return true;
    }
}