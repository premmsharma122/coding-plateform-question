class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n =grid.length;
        int m =grid[0].length;
        if(n==0 || m==0 || grid[0][0]!=0 || grid[n-1][m-1]==1) return -1;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];

        int[][] dir = {
    {-1, -1}, {-1, 0}, {-1, 1},
    { 0, -1},          { 0, 1},
    { 1, -1}, { 1, 0}, { 1, 1}
};
        q.add(new int[]{0,0});
        vis[0][0] =true;
        
        int c = 1;

    while(!q.isEmpty()){

    int size = q.size();

    for(int i = 0; i < size; i++){

        int[] arr = q.poll();

        if(arr[0] == n - 1 && arr[1] == m - 1){
            return c;
        }

        for(int[] a : dir){

            int nx = arr[0] + a[0];
            int ny = arr[1] + a[1];

            if(nx >= 0 && ny >= 0 &&
               nx < n && ny < m &&
               !vis[nx][ny] &&
               grid[nx][ny] == 0){

                vis[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

        c++;
    }

    return -1;
    }
}