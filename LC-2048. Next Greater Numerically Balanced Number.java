class Solution {
    public boolean help(int n){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int d =n;
        int d2=n;
        while(d>0){
            int r = d%10;
            hm.put(r,hm.getOrDefault(r,0)+1);
            d=d/10;
        }
        while(d2>0){
            int r = d2%10;
            if(hm.get(r)!=r){
                return false;
            }
            d2=d2/10;
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        boolean f = false;
        if(n==1) return 22;
        while(f!=true){
            n++;
            if(help(n)){
                f=true;
                return n;
            }
        }
        return -1;
    }
}
