class Solution {
    public void rotate(int[][] matrix) {
        int n =matrix.length;
        // 1. Transpose..
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int tm= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tm;
            }
        }
        // 2. Reverse each row..
        for(int i=0; i<n; i++){
            int l=0, r=n-1;
            while(l<r){
                int tm = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = tm;
                l++;
                r--; 
            }
        }
    }
}