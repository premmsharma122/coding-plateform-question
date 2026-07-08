class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
       PriorityQueue<int[]> mx = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i=0; i<profit.length; i++){
            mx.offer(new int[]{profit[i],difficulty[i]});
        }
        List<Integer> wrk = new ArrayList<>();
        for(int a : worker){
            wrk.add(a);
        }
        Collections.sort(wrk,Collections.reverseOrder());
        int s=0,i=0;
        while(i<worker.length && !mx.isEmpty()){
            if(mx.peek()[1]>wrk.get(i)){
                mx.poll();
            }else{
                s+=mx.peek()[0];
                i++;
            }
        }

        return s;
    }
}