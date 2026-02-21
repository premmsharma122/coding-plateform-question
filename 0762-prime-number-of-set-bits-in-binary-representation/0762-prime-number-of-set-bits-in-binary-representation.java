class Solution {
    public  boolean help(int n){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int r  = n%2;
            sb.append(r);
            n/=2;
        }
        sb.reverse();
        boolean res = help2(sb.toString());
        return res;
    }
    public boolean help2(String nm){
        int c=0;
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

        for(char a : nm.toCharArray()){
            if(a=='1') c++;
        }
        if(hs.contains(c)){
            return true;
        }
        return false;
    }
    public int countPrimeSetBits(int left, int right) {
        int ct=0;
        for(int i=left; i<=right; i++){
            if(help(i)) ct++;
        }
        return ct;
    }
}