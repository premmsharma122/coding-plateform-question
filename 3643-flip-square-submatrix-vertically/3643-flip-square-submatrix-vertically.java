class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int row =x, lastrow=x+k-1;
        while(row<lastrow){
            for(int i=y; i<y+k; i++){
                int tmp = grid[row][i];
                grid[row][i] = grid[lastrow][i];
                grid[lastrow][i]=tmp;
            }
            row++;
            lastrow--;
        }
        return grid;
    }
}