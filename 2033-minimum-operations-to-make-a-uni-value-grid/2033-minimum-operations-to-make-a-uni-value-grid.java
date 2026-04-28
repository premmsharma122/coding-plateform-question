class Solution {
    public int minOperations(int[][] grid, int x) {
        int n =grid.length;
        int m = grid[0].length;
        int arr[] = new int[n*m];
        int idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[idx++]=grid[i][j];
            }
        }
        int rem = arr[0]%x;
        for(int i=1; i<arr.length; i++){
            int cur= arr[i]%x;
            if(cur!=rem) return -1;
        }
        Arrays.sort(arr);
        int mid = arr[arr.length / 2];
        int op=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=mid){
                if(arr[i]>mid){
                    while(arr[i]!=mid){
                        arr[i]-=x;
                        op++;
                    }
                }else{
                    while(arr[i]!=mid){
                        arr[i]+=x;
                        op++;
                    }
                }
            }
        }
        return op;
    }
}