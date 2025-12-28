class Solution {

    int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] arr = new int[k]; // arr[i] = cookies of child i
        backtrack(cookies, 0, arr, k);
        return ans;
    }

    void backtrack(int[] cookies, int idx, int[] arr, int k) {

        // base case: saari cookies assign ho gayi
        if (idx == cookies.length) {
            int max = 0;
            for (int x : arr) {
                max = Math.max(max, x);
            }
            ans = Math.min(ans, max);
            return;
        }

        // current cookie ko har child ko try karo
        for (int i = 0; i < k; i++) {
            arr[i] += cookies[idx];           // choose
            backtrack(cookies, idx + 1, arr, k);
            arr[i] -= cookies[idx];           // undo
        }
    }
}
