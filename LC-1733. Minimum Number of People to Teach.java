class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> s = new HashSet<>();
        for(int f[] : friendships){
            int a = f[0]-1, b = f[1]-1;
            boolean fl =false;
            for(int x : languages[a]){
                for(int y : languages[b]){
                    if(x==y) {
                        fl = true;
                        break;
                    }
                }
                if(fl) break;
            }
            if(!fl){
                s.add(a);
                s.add(b);
            }
        }
        int ans =languages.length+1;
        for(int i=1; i<=n; i++){
            int c=0;
            for (int u : s){
                boolean check = false;
                for(int l : languages[u]){
                    if(i==l){
                        check = true;
                        break;
                    }
                }
            if(!check) c++;
            }
            ans = Math.min(ans,c);
     
        }
        return ans;
    }
}
