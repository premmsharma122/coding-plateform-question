class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char a : s.toCharArray()){
            hm.put(a, hm.getOrDefault(a,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(char a : hm.keySet()){
            pq.add(new int[]{a,hm.get(a)});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int c[] = pq.poll();
            char ch = (char)c[0];
            while(c[1]-->0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}