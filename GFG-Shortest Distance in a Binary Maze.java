// User function Template for Java
class Tuple{
    int f, s, t;
    Tuple(int f ,int s,int t){
        this.f=f;
        this.s=s;
        this.t=t;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        if(source[0]==destination[0] && destination[1]==source[1]) return 0;
        int tmp[][] = new int[grid.length][grid[0].length];
        for(int i=0; i<tmp.length; i++){
            Arrays.fill(tmp[i],Integer.MAX_VALUE);
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,source[0],source[1]));
        tmp[source[0]][source[1]]=0;
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        while(!q.isEmpty()){
            Tuple cur = q.peek();
            q.remove();
            int d = cur.f;
            int r = cur.s;
            int c = cur.t;
            
            for(int i=0; i<4; i++){
                int nr = dr[i]+r;
                int nc = dc[i]+c;
                
                if(nr>=0 && nc>=0 && nr < grid.length && nc< grid[0].length && grid[nr][nc]==1 && d+1<tmp[nr][nc]){
                    tmp[nr][nc] = d+1;
                    if(destination[0]==nr && destination[1]==nc) return d+1;
                    q.add(new Tuple(d+1,nr,nc));
                }
            }
        }
        return -1;
        
        
    }
}
