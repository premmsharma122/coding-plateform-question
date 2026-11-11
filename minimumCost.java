class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ls[]= {(long)cost1,(long)cost2, (long )costBoth,(long)need1, (long)need2};
        long a1 =ls[0];
        long a2 = ls[1];
        long a3=ls[2];
        long b1 = ls[3];
        long b2 =ls[4];
        long ct = (b1*a1)+(b2*a2);
        long nd = Math.min(b1,b2);
        long cm = (nd*a3) + ((b1-nd)*a1) + ((b2-nd)*a2);
        long mx = Math.max(b1,b2);
        long cmx = (mx * a3);
        return Math.min(ct, Math.min(cmx,cm));
    }
}
