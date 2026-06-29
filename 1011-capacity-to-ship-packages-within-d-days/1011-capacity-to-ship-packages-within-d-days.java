class Solution {

    public boolean help(int m, int[] arr, int d) {
        int day = 1;
        int sum = 0;
        for(int i= 0; i < arr.length; i++) {
            if (sum + arr[i] <= m) {
                sum += arr[i];
            }else {
                day++;
                  sum = arr[i];
            }
        }

        return day <= d;
    }

    public int shipWithinDays(int[] weights, int days) {
        int mx = 0;
        int sum = 0;

        for (int a : weights) {
            mx = Math.max(mx, a);
            sum += a;
        }

        int ans = sum;
        int l = mx, h = sum;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (help(mid, weights, days)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}