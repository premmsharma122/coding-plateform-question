class Solution {
    public int dfs(int b[][], int r, int c){
        int[] dr = {-1,-1,-1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1,-1, 1,-1, 0, 1};
        int rw = b.length, cl = b[0].length;
        int cnt=0;
        for(int i=0; i<8; i++){
           int nr = r+dr[i], nc = c+dc[i];
            if (nr >= 0 && nr < rw && nc >= 0 && nc < cl) {
                if(Math.abs(b[nr][nc])==1) cnt++;
            }
        }
        return cnt;
    }
    public void gameOfLife(int[][] board) {
        int r=board.length, c=board[0].length;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int live = dfs(board, i, j);
                if(board[i][j]==1){
                    if(live<2 || live>3){
                        board[i][j] = -1;
                    }
                }else{
                    if(live==3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j]==-1) board[i][j]=0;
                if(board[i][j]==2) board[i][j]= 1;
            }
        }
        
    }
}
