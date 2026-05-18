class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            hm.putIfAbsent(arr[i],new ArrayList<>());
            hm.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[arr.length];
        q.add(0);
        vis[0]=true;
        int st=0;
        while(!q.isEmpty()){
           int size = q.size();
           while(size-->0){
            int idx = q.poll();
            if(idx==arr.length-1) return st;
            if(idx+1<arr.length &&  !vis[idx+1]){
                q.add(idx+1);
                vis[idx+1]=true;
            }
            if(idx-1>=0 && !vis[idx-1]){
                q.add(idx-1);
                vis[idx-1]=true;
            }
            ArrayList<Integer> cur  = hm.get(arr[idx]);
            for(int a : cur){
                if(!vis[a]){
                    vis[a]=true;
                    q.add(a);
                }
            }
            cur.clear();

           }
           st++;
        }
        return -1;
    }
}