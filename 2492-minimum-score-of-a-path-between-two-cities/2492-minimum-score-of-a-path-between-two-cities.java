class Solution {
    public int minScore(int n, int[][] roads) {
        // 1. if graph is connected then just find the min weight -> answer
        // 2. if not connected then elimenat the rest other than 1-n -> min in the 1-n -> answer.
        List<int[]>[] g = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            g[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            g[road[0]].add(new int[]{road[1], road[2]});
            g[road[1]].add(new int[]{road[0], road[2]});
        }
        boolean sen[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        sen[1]=true;
        int ans = 1000000;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int c[] : g[cur]){
                ans =Math.min(ans,c[1]);
                if(!sen[c[0]]){
                    q.offer(c[0]);
                    sen[c[0]]=true;
                }
            }
        }
        return ans;
    }
}