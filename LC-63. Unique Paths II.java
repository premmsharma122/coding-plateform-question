class Solution {
    public int help(int n, int m , int i, int j, int arr[][], int memo[][]){
        if(i>=n || i<0 || j>=m || j<0 || arr[i][j]==1) return 0;
        if(i==n-1 && j==m-1) return 1;
        if(memo[i][j] != -1) return memo[i][j];
        int r = help(n,m, i+1,j,arr,memo);
        int d = help(n,m, i,j+1,arr,memo);
        return memo[i][j] =  r+d;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int memo[][] = new int[101][101];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        return help(arr.length, arr[0].length, 0,0,arr,memo);
    }
}
