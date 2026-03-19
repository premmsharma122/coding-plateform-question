class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n=grid[0].length;
        int ans=0;
        int px[]= new int[n];
        int py[]= new int[n];

        for(int i=0; i<m; i++){
            int row =0, col=0;
            for(int j=0; j<n; j++){
                if(grid[i][j]=='X') row++;
                else if(grid[i][j]=='Y') col++;

                px[j]+=row;
                py[j]+=col;
                if(px[j]==py[j] && px[j]>0){
                    ans++;
                }
            }
        }
        return ans;
    }
}