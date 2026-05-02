class Solution {
    public boolean help(int n ){
        int nm =n;
        HashSet<Integer> hm = new HashSet();
        hm.add(4);
        hm.add(3);
        hm.add(7);
        boolean f =false;
        while(nm>0){
            int r = nm%10;
            nm=nm/10;
            if(hm.contains(r)) return false;
            if(r==2 || r==6 || r==5 || r==9) f=true;
        }
        if(f) return true;
        return false;
    }
    public int rotatedDigits(int n) {
        int ans=0;
        for(int i=1; i<=n; i++){
            if(help(i)) ans++;
        }
        return ans;
    }
}