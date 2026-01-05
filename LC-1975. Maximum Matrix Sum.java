class Solution {
     public long maxMatrixSum(int[][] matrix) {
        int ng=0;
        long sum=0, absum=0, abmin=Integer.MAX_VALUE;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0) ng++;
                abmin = Math.min(abmin,Math.abs(matrix[i][j]));
            }
        }
        if(ng%2==1){
            return sum- 2L*abmin;
        }
        return sum;

    }
}
