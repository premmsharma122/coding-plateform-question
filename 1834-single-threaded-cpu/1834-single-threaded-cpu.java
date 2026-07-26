class Solution {
    public int[] getOrder(int[][] tasks) {
        int n =tasks.length;
        int sortT[][] = new int[n][];
        for(int i=0; i<n; i++){
            sortT[i]=new int[]{tasks[i][0],tasks[i][1],i};
        }
        Arrays.sort(sortT,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]!=b[1] ? a[1]-b[1] :a[2]-b[2]);
        int res[] = new int[n];
        int idx=0,taskIdx=0;
        long time=0;
        while(idx<n){
            while(taskIdx<n && sortT[taskIdx][0]<=time){
                pq.offer(sortT[taskIdx++]);
            }
            if(pq.isEmpty()){
                time= sortT[taskIdx][0];
                continue;
            }
            int cur[] = pq.poll();
            res[idx++]=cur[2];
            time+=cur[1];
        }
        return res;
    }
}