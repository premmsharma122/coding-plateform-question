class Solution {
    public class Node{
        int f;
        int s;
        int t;
        Node(int f, int s, int t){
            this.f = f;
            this.s = s;
            this.t = t;
        }
    }
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        boolean sen[][] = new boolean[n][m];
        int dist[][] = new int[n][m];
        
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    sen[i][j] = true;
                    q.add(new Node(i,j,0));
                }
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,-1,0,1};
        while(!q.isEmpty()){
            int r = q.peek().f;
            int c = q.peek().s;
            int o = q.peek().t;
            dist[r][c] = o;
            q.remove();
            for(int i=0; i<4; i++){
                int nr = r+drow[i];
                int nc = c+dcol[i];
                if(nr>=0 && nr < n && nc >=0 && nc < m && !sen[nr][nc] ){
                    sen[nr][nc] = true;
                    q.add(new Node(nr,nc,o+1));
                }
            }
            
        }
        return dist;
        
    }
}
