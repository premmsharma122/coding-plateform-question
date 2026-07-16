class Solution {
    public long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        long ans[] = new long[nums.length];
        long min = Long.MAX_VALUE;
        long pr[] = new long[nums.length];
        pr[0]=nums[0];
        ans[0]= gcd(pr[0],nums[0]);

        for(int i=1; i<nums.length; i++){
            pr[i] = Math.max(pr[i-1],nums[i]);
            ans[i] = gcd(pr[i],nums[i]);
        }
        /*for (int i = 0; i < nums.length; i++) {
            long mx = Long.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                mx = Math.max(mx, nums[j]);
            }
            ans[i] = gcd(mx, nums[i]);
        }
        */
        
        Arrays.sort(ans);
        if (ans.length % 2 == 0) {
            int i = 0, j = ans.length - 1;
            long val = 0;
            while (i < j) {
                val += gcd(ans[i], ans[j]);
                i++;
                j--;
            }
            return val;
        } else {
            int i = 0, j = ans.length - 1;
            long val = 0;
            while (i < j) {
                val += gcd(ans[i], ans[j]);
                i++;
                j--;
            }
            return val;
        }

    }
}