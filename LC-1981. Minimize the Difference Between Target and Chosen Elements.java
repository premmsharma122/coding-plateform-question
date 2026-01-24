// class Solution {

//     int[][] memo;

//     public int help(int[][] mat, int row, int sum, int target) {

//         // cap sum
//         if (sum > target) sum = target;

//         if (row == mat.length) {
//             return Math.abs(target - sum);
//         }

//         if (memo[row][sum] != -1)
//             return memo[row][sum];

//         int ans = Integer.MAX_VALUE;

//         for (int col = 0; col < mat[0].length; col++) {
//             ans = Math.min(
//                     ans,
//                     help(mat, row + 1, sum + mat[row][col], target)
//             );
//         }

//         return memo[row][sum] = ans;
//     }

//     public int minimizeTheDifference(int[][] mat, int target) {

//         memo = new int[mat.length][target + 1];

//         for (int i = 0; i < mat.length; i++) {
//             Arrays.fill(memo[i], -1);
//         }

//         return help(mat, 0, 0, target);
//     }
// }

class Solution {

    int[][] memo;

    public int help(int[][] mat, int row, int sum, int target) {

        if (row == mat.length) {
            return Math.abs(target - sum);
        }

        if (memo[row][sum] != -1)
            return memo[row][sum];

        int ans = Integer.MAX_VALUE;

        for (int col = 0; col < mat[0].length; col++) {
            ans = Math.min(
                    ans,
                    help(mat, row + 1, sum + mat[row][col], target)
            );
        }

        return memo[row][sum] = ans;
    }

    public int minimizeTheDifference(int[][] mat, int target) {

        int rows = mat.length;
        int cols = mat[0].length;

        int maxSum = rows * 70; // max constraint

        memo = new int[rows][maxSum + 1];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(memo[i], -1);
        }

        return help(mat, 0, 0, target);
    }
}
