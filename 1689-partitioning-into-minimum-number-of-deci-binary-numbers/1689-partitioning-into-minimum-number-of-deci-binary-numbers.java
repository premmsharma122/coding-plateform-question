class Solution {
    public int minPartitions(String n) {
        int m = Integer.MIN_VALUE;
        for(char a : n.toCharArray()){
            int d = a-'0';
            m= Math.max(d,m);
        }
        return m;
    }
}