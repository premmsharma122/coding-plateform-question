class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m=matrix.length, n =matrix[0].length;
        int ans=0;
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==1){
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
        }
        for(int i=0; i<m; i++){
            int arr[] = matrix[i].clone();
            Arrays.sort(arr);
            for(int j=0; j<arr.length; j++){
                int h =arr[j];
                int w = n-j;
                ans =Math.max(ans,h*w);
            }
        }
        return ans;
    }
}