class Solution {
    Boolean t[][][];
    
    boolean help(int d, int r, int c, char g[][]) {
        if (d >= g.length || r >= g[0].length) return false;

        if (g[d][r] == '(') {
            c++;
        } else {
            c--;
        }

        if (c < 0) return false;

        if (d == g.length - 1 && r == g[0].length - 1) {
            return c == 0;
        }

        if (t[d][r][c] != null) return t[d][r][c];

        boolean down = help(d + 1, r, c, g);
        boolean ri = help(d, r + 1, c, g);

        return t[d][r][c] = down || ri;
    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        t = new Boolean[m][n][m + n];

        return help(0, 0, 0, grid);
    }
}
