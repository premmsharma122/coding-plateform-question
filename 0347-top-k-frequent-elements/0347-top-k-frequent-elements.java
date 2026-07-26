class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int a : nums){
            hm.put(a, hm.getOrDefault(a,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int v : hm.keySet()){
            pq.offer(new int[]{v,hm.get(v)});
        }
        int ans[] = new int[k];
        int idx=0;
        while(k-->0){
            int cur[] = pq.poll();
            ans[idx++]=cur[0];
        }
        return ans;
    }
}