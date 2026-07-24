class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int v : piles){
            p.offer(v);
        }
        while(k-->0){
            int c = p.poll();
            c=c-c/2;
            p.offer(c);
        }
        int s =0;
        for(int v : p){
            s+=v;
        }
        return s;
    }
}