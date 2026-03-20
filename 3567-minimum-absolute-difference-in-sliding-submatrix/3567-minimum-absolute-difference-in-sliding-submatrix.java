import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int r = n - k + 1;
        int c = m - k + 1;

        int[][] ans = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                List<Integer> list = new ArrayList<>();

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        list.add(grid[x][y]);
                    }
                }

                Collections.sort(list);

                int minDiff = Integer.MAX_VALUE;
                boolean found = false;

                for (int t = 1; t < list.size(); t++) {
                    if (!list.get(t).equals(list.get(t - 1))) {  
                        minDiff = Math.min(minDiff, list.get(t) - list.get(t - 1));
                        found = true;
                    }
                }

                ans[i][j] = found ? minDiff : 0; 
            }
        }

        return ans;
    }
}