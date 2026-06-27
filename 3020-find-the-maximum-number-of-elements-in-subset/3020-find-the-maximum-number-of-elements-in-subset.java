class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int a : nums){
            hm.put(a,hm.getOrDefault(a,0)+1);
        }
        int ans =1;
        for(int x : nums){
            if(x==1){
                if(hm.get(x)%2!=0){
                    ans=Math.max(ans,hm.get(x));
                }else{
                    ans=Math.max(ans,hm.get(x)-1);
                }
            }else{
                int c=0;
                if(hm.get(x)>=2){
                    long cur =x;
                    while(cur<=Integer.MAX_VALUE && hm.containsKey((int)cur)){
                        if(hm.get((int)cur)==1){
                            c++;
                            break;
                        }
                        c++;
                        if(cur>Long.MAX_VALUE/cur) break;
                        cur*=cur;
                    }
                }
                ans = Math.max(ans,c*2-1);
            }
        }
        return ans;
    }
}