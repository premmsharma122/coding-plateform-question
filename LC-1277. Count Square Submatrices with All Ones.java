class Solution {
    public int help(int arr[][], int i, int j, int memo[][]){
        if(i>arr.length-1 || j>arr[0].length-1 || arr[i][j] == 0 ) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        int r= help(arr,i+1,j,memo);
        int d = help(arr,i,j+1,memo);
        int dg = help(arr,i+1,j+1,memo);

        return memo[i][j] =  1 + Math.min(r,Math.min(d,dg));
    }
    public int countSquares(int[][] matrix) {
        int memo[][] = new int[301][301];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        int ans=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans += help(matrix, i, j,memo);
            }
        }
        return ans;
    }
}
