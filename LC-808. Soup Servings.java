class Solution {
    static int[][] arr = {{4,0},{3,1},{2,2},{1,3}};
    static double[][] memo;

    public double help(int a, int b){
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1;
        if (b <= 0) return 0;

        if (memo[a][b] != -1) return memo[a][b];

        double pro = 0;
        for (int i = 0; i < 4; i++) {
            pro += help(a - arr[i][0], b - arr[i][1]);
        }

        return memo[a][b] = 0.25 * pro;
    }

    public double soupServings(int n) {
        if (n >= 4800) return 1.0; 

        int m = (n + 24) / 25;      // scale down
        memo = new double[m + 1][m + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return help(m, m);
    }
}
