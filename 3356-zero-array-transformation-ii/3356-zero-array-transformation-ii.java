class Solution {

    public boolean dft(int nums[], int q[][], int mid){

        int dif[] = new int[nums.length];

        for(int i = 0; i <= mid; i++){

            int l = q[i][0];
            int r = q[i][1];
            int x = q[i][2];

            dif[l] += x;

            if(r + 1 < nums.length)
                dif[r + 1] -= x;
        }

        int cur = 0;

        for(int i = 0; i < nums.length; i++){

            cur += dif[i];

            if(nums[i] - cur > 0)
                return false;
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {

        boolean ok = true;

        for(int x : nums){
            if(x > 0){
                ok = false;
                break;
            }
        }

        if(ok) return 0;

        int q = queries.length;

        int l = 0, r = q - 1;

        int res = -1;

        while(l <= r){

            int mid = l + (r - l) / 2;

            if(dft(nums, queries, mid)){

                res = mid + 1;

                r = mid - 1;

            }else{

                l = mid + 1;
            }
        }

        return res;
    }
}