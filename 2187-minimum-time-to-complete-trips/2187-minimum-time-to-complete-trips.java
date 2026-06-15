class Solution {

    public boolean help(long m, int arr[], int tot) {
        long s = 0;

        for (int i = 0; i < arr.length; i++) {
            s += m / arr[i];

            if (s >= tot) return true;
        }

        return false;
    }

    public long minimumTime(int[] time, int totalTrips) {

        int minTime = Integer.MAX_VALUE;
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        long l = 1;
        long h = (long) minTime * totalTrips;
        long ans = h;

        while (l <= h) {
            long mid = l + (h - l) / 2;

            if (help(mid, time, totalTrips)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}