class Solution {
    public int largestAltitude(int[] gain) {
        int pr=0, m= Integer.MIN_VALUE;
        m = Math.max(m,pr);
        for(int a: gain){
            pr+=a;
            m = Math.max(m,pr);
        }
        return m;
    }
}