class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] mx = new int[n];
        for(int i=0;i<n;i++){
            mx[i] = -1;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1){
                    mx[i] = j;
                    break;
                }
            }
        }
        int swaps = 0;
        for(int i=0;i<n;i++){

            int j = i;
            while(j<n && mx[j] > i) j++;

            if(j==n) return -1;
            while(j>i){
                int temp = mx[j];
                mx[j] = mx[j-1];
                mx[j-1] = temp;
                swaps++;
                j--;
            }
        }

        return swaps;
    }
}