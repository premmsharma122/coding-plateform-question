class Solution {
    public boolean dfs(int i, int j,int g[][], Map<Integer, int[][]> direc,int n , int m,boolean vis[][] ){
        if(i==n-1 && j==m-1) return true;
        vis[i][j] = true;
        int dir[][] = direc.get(g[i][j]);
        for(int d[] : dir){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni<0 || nj<0 || ni>=n || nj>=m || vis[ni][nj]) continue;
            int nxt[][] = direc.get(g[ni][nj]);
            for(int b[] : nxt){
                if(b[0]==-d[0] && b[1]==-d[1]){
                    if(dfs(ni,nj,g,direc,n,m,vis)) return true;
                }
            }
        }
            return false;
    }
    public boolean hasValidPath(int[][] grid) {
        Map<Integer, int[][]> directions = new HashMap<>();

        directions.put(1, new int[][]{{0, -1}, {0, 1}});   // left, right
        directions.put(2, new int[][]{{1, 0}, {-1, 0}});   // down, up
        directions.put(3, new int[][]{{0, -1}, {1, 0}});   // left, down
        directions.put(4, new int[][]{{0, 1}, {1, 0}});    // right, down
        directions.put(5, new int[][]{{0, -1}, {-1, 0}});  // left, up
        directions.put(6, new int[][]{{0, 1}, {-1, 0}});   // right, up
        boolean vis[][]  = new boolean[grid.length][grid[0].length];
        int n = grid.length, m  = grid[0].length;
        return dfs(0,0,grid,directions,n,m,vis);
    }
}