class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : stones){
            pq.offer(a);
        }
        while(pq.size()>=2){
            int f1= pq.poll();
            int f2 = pq.poll();
            if(f1!=f2){
                pq.offer(f1-f2);
            }
        }
        return pq.size()>=1? pq.peek():0;
    }
}