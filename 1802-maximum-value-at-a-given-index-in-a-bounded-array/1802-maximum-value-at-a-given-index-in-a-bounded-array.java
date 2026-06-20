class Solution {

    public long help(long c, long mid){
        return c * mid - (c * (c + 1) / 2);
    }

    public int maxValue(int n, int index, int maxSum) {

        long res = 0;
        long l = 1, h = maxSum;

        while(l <= h){

            long mid = l + (h - l) / 2;

            long left_c = Math.min(index, (int)(mid - 1));
            long left_s = help(left_c, mid);
            left_s += Math.max(0L, index - (mid - 1)); // extra ones

            long right_c = Math.min(n - index - 1, (int)(mid - 1));
            long right_s = help(right_c, mid);
            right_s += Math.max(0L, (n - index - 1) - (mid - 1)); // extra ones

            long tot = left_s + mid + right_s;

            if(tot <= maxSum){
                res = mid;
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }

        return (int)res;
    }
}