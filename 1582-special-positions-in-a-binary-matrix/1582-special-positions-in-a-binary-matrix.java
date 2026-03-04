class Solution {
    public int helpr(int r, int g[][]){
        int cr=0;
        for(int i=0; i<g[0].length; i++){
            if(g[r][i]==1) cr++;
        }
        return cr;
    }
    public int helpc(int c, int g[][]){
        int cc=0;
        for(int i=0; i<g.length; i++){
            if(g[i][c]==1) cc++;
        }
        return  cc;
    }
    public int numSpecial(int[][] mat) {
        int ans=0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1){
                    int r= helpr(i,mat);
                    int c = helpc(j,mat);
                    if(r==1 && c==1) ans++;
                }
            }
        }
        return ans;
    }
}