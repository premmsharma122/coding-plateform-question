class Solution {
    int[][][] memo;

    int help(int idx, int[] arr, int buy, int l) {
        if (idx >= arr.length || l == 0) return 0;

        if (memo[idx][buy][l] != -1)
            return memo[idx][buy][l];

        int res;
        if (buy == 1) {
            int tk = help(idx + 1, arr, 0, l) - arr[idx];
            int sk = help(idx + 1, arr, 1, l);
            res = Math.max(tk, sk);
        } else {
            int sell = help(idx + 1, arr, 1, l - 1) + arr[idx];
            int sk = help(idx + 1, arr, 0, l);
            res = Math.max(sell, sk);
        }

        return memo[idx][buy][l] = res;
    }

    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2][3];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return help(0, prices, 1, 2);
    }
}
