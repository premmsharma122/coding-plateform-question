class Solution {
   public boolean dfs(char c,char g[][], int i, int j, int pi, int pj, boolean vis[][]){
    vis[i][j]=true;
    int di[] = {1,0,-1,0};
    int dj[] = {0,1,0,-1};
    for(int d=0;  d<4; d++){
        int ni = i+di[d];
        int nj = j+dj[d];
        if(ni<0 || nj<0 || ni>=g.length || nj>=g[0].length) continue;
        if(g[ni][nj]!=c) continue;
        if(!vis[ni][nj]){
            if(dfs(c,g,ni,nj,i,j,vis)) return true;
        }
        else if(ni !=pi || nj!= pj) return true;
    }
    return false;
   }
    public boolean containsCycle(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            Arrays.fill(vis[i],false);
        }
        for(int i=0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
            char c= grid[i][j];
            if(!vis[i][j]){
                if(dfs(c,grid,i,j,-1,-1,vis)) return true;
            }
            }
        }
        return false;
    }
}