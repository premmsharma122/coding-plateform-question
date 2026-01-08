class Solution {
    int memo[][];
    int n,m;
    int[] a,b;
    public int help(int i, int j){
        if(i==n || j==m) return Integer.MIN_VALUE;
        if(memo[i][j] != Integer.MIN_VALUE) return memo[i][j];
        int prd = a[i]*b[j];
        int nxt = help(i+1,j+1);
        int tk = prd;
        if(nxt != Integer.MIN_VALUE){
            tk = Math.max(tk, prd+nxt);
        }
        int sk1 = help(i+1,j);
        int sk2 = help(i,j+1);
        return memo[i][j] = Math.max(tk, Math.max(sk1,sk2));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        memo = new int[nums1.length+1][nums2.length+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],Integer.MIN_VALUE);
        }
        n=nums1.length;
        m=nums2.length;
        a = nums1;
        b=nums2;
        return help(0,0);
    }
}
