class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int ans[][] = new int[isWater.length][isWater[0].length];
        for(int i=0; i<ans.length; i++){
            Arrays.fill(ans[i],-1);
        }
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<isWater.length; i++){
            for(int j=0; j<isWater[0].length; j++){
                if(isWater[i][j]==1){
                    ans[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int s =q.size();
            while(s-->0){
                int cur[] = q.poll();
                for(int a[] : dir){
                    int nx = a[0]+cur[0];
                    int ny =a[1]+cur[1];
                    if(nx>=0 && ny>=0 && nx<isWater.length && ny<isWater[0].length && ans[nx][ny]==-1){
                        ans[nx][ny]=ans[cur[0]][cur[1]]+1;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return ans;
    }
}