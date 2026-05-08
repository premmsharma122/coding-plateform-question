class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        int max = 1000000;
        boolean prime[] = new boolean[max+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]= false;
        // step 1 : Prime Find by sieve
        for(int i=2; i*i<=max; i++){
            if(prime[i]){
                for(int j=i*i; j<=max; j+=i){
                    prime[j]=false;
                }
            }
        }
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            int val = nums[i];
            for(int j=2; j*j<=val; j++){
                if(val%j==0){
                    hm.computeIfAbsent(j,k->new ArrayList<>()).add(i);
                    while(val%j==0){
                        val/=j;
                    }
                }
            }
            if(val>1){
                hm.computeIfAbsent(val,k->new ArrayList<>()).add(i);
            }
        }
        //step 3 : Perfome DFS
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        vis[0]=true;
        q.offer(0);
        int st=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int idx = q.poll();
                if(idx==n-1) return  st;
                if(idx+1 < n && !vis[idx+1]){
                    vis[idx+1]=true;
                    q.offer(idx+1);
                }
                if(idx-1>=0 && !vis[idx-1]){
                    vis[idx-1]=true;
                    q.offer(idx-1);
                }
                int val = nums[idx];
                if(prime[val] && hm.containsKey(val)){
                    for(int v : hm.get(val)){
                        if(!vis[v]){
                            q.offer(v);
                            vis[v] = true;
                        }
                    }
                    hm.remove(val);
                }
            }
            st++;
        }
        return -1;
    }
}