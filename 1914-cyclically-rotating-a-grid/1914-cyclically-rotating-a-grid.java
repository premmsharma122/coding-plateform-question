class Solution {

    public static void rotate(List<Integer> l, int k) {
        int n = l.size();
        k %= n;

        reverse(l, 0, n - 1);
        reverse(l, 0, n - k - 1);
        reverse(l, n - k, n - 1);
    }

    public static void reverse(List<Integer> l, int s, int e) {
        while (s < e) {
            int tmp = l.get(s);
            l.set(s, l.get(e));
            l.set(e, tmp);
            s++;
            e--;
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {

        int r = grid.length;
        int c = grid[0].length;

        int top = 0, left = 0;
        int bottom = r - 1, right = c - 1;

        while (top < bottom && left < right) {

            List<Integer> l = new ArrayList<>();

            for (int j = left; j <= right; j++) {
                l.add(grid[top][j]);
            }

            for (int i = top + 1; i <= bottom - 1; i++) {
                l.add(grid[i][right]);
            }

            for (int j = right; j >= left; j--) {
                l.add(grid[bottom][j]);
            }

            for (int i = bottom - 1; i >= top + 1; i--) {
                l.add(grid[i][left]);
            }

            rotate(l, k);

            int idx = 0;

            for (int j = left; j <= right; j++) {
                grid[top][j] = l.get(idx++);
            }

            for (int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right] = l.get(idx++);
            }

            for (int j = right; j >= left; j--) {
                grid[bottom][j] = l.get(idx++);
            }

            for (int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left] = l.get(idx++);
            }

            top++;
            left++;
            bottom--;
            right--;
        }

        return grid;
    }
}