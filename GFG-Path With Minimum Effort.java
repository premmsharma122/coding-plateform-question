class Tuple{
    int dis,  r, c;
    Tuple(int dis, int r, int c){
        this.dis = dis;
        this.r = r;
        this.c=c;
    }
}
class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> a.dis-b.dis);
        int ds[][] = new int[rows][columns];
        for(int i=0; i<rows; i++){
            Arrays.fill(ds[i],Integer.MAX_VALUE);
        }
        ds[0][0] =0;
        pq.add(new Tuple(0,0,0));
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        while(!pq.isEmpty()){
            int d = pq.peek().dis;
            int r = pq.peek().r;
            int c = pq.peek().c;
            pq.remove();
            if(r==rows-1 && c==columns-1) return d;
            
            for(int i=0; i<4; i++){
                int nr = dr[i]+r;
                int nc = dc[i]+c;
                
                if(nr>=0 && nc>=0 && nr<rows && nc < columns){
                    int ans = Math.max(Math.abs(heights[r][c]-heights[nr][nc]), d);
                    if(ans < ds[nr][nc]){
                        ds[nr][nc] = ans;
                        pq.add(new Tuple(ans,nr,nc));
                    }
                }
            }
        }
        return 0;
        
    }
}
