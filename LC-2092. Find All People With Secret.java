class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a,b)-> a[2]-b[2]); // based on third place in ascending order
        boolean ch[] = new boolean[n];
        ch[0] = true;
        ch[firstPerson] = true;
        int m = meetings.length, i=0;
        
        while(i<m){
            int curr = meetings[i][2];
        Map<Integer, List<Integer>> mp = new HashMap<>(); //undirected
        Set<Integer> st = new HashSet<>();
        while(i<m  && meetings[i][2]==curr){
            int x = meetings[i][0];
            int y = meetings[i][1];
            mp.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            mp.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            st.add(x);
            st.add(y);
            i++;
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int a : st){
            if(ch[a] && !seen.contains(a)){
                q.offer(a);
                seen.add(a);
            }
        }
        while(!q.isEmpty()){
            int cr = q.poll();
            if(!mp.containsKey(cr)) continue;
            for(int nm : mp.get(cr)){
                if(!seen.contains(nm)){
                    seen.add(nm);
                    ch[nm] = true;
                    q.offer(nm);
                }
            }
        }
        }
        List<Integer> res = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (ch[p]) {
                res.add(p);
            }
        }
        return res;
    }
}
