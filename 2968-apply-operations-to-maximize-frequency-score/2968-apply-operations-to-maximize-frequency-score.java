class Solution {
    public boolean help(int len , int nums[], long k, long prefix[]){
        if(len==0) return false;
        int i = 0;
        int j = len - 1;

        while (j < nums.length) {
            long targetIdx = (i + j) / 2;
            long target = nums[(int) targetIdx];

            long operationsLeft;
            long operationsRight;

            if (targetIdx == 0) {
                operationsLeft = 0;
            } else {
                operationsLeft = Math.abs(((targetIdx - i) * target)
                        - (prefix[(int) targetIdx - 1] - (i > 0 ? prefix[i - 1] : 0)));
            }

            operationsRight = Math.abs(((j - targetIdx) * target) - (prefix[j] - prefix[(int) targetIdx]));

            if (operationsRight + operationsLeft <= k) {
                return true;
            }

            i++;
            j++;
        }

        return false;

    }
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        int l=1, r=nums.length, ans=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(help(mid,nums,k,prefix)){
                ans = mid;
                l=mid+1;
            }else r=mid-1;
        }
        return ans;
    }
}