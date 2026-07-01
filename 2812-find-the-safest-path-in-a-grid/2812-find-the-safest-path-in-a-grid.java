class Solution {
    private static int n;
    private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean dfs(int r, int c, int safe, int dist[][], boolean sen[][]){
        if(r==n-1 && c==n-1) return true;
        sen[r][c]=true;
        for(int d[]:dir){
            int nr = r+d[0];
            int nc=c+d[1];

            if(nr>=0 && nr<n && nc>=0 && nc<n &&
               !sen[nr][nc] && dist[nr][nc]>=safe){

                if(dfs(nr,nc,safe,dist,sen))
                    return true;
            }
        }

        return false;
        
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n=grid.size();
        int dist[][] = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i],-1);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int d[]: dir){
                int nr = cur[0]+d[0];
                int nc = cur[1]+d[1];

                if(nr>=0 && nc>=0 && nr<n && nc<n && dist[nr][nc]==-1){
                    dist[nr][nc]=dist[cur[0]][cur[1]]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        int l =0,h=400, ans=0;
        while(l<=h){
            int mid= l+(h-l)/2;
            boolean sen[][]= new boolean[n][n];
            if(dist[0][0]>=mid && dfs(0,0,mid,dist,sen)){
                ans =mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
}
