class Solution {
    public void dfs(int i,int j, char g[][]){
        if(i<0 || j<0 || i>=g.length || j>=g[0].length || g[i][j]!='1') return;
        g[i][j]='0';
        dfs(i+1,j,g);
        dfs(i-1,j,g);
        dfs(i,j+1,g);
        dfs(i,j-1,g);
    }
    public int numIslands(char[][] grid) {
        int c=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    c++;
                    dfs(i,j,grid);
                }
            }
        }
        return c;
    }
}