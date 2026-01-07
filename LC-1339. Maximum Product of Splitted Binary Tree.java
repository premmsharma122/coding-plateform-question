/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long tot = 0;
    long max = 0;
    int MOD = 1_000_000_007;
    public void sum(TreeNode r){
        if(r == null) return;
        tot += r.val;
        sum(r.left);
        sum(r.right);
    }
    public long help(TreeNode r){
        if(r == null) return 0;

        long left = help(r.left);
        long right = help(r.right);

        long sub = left + right + r.val;

        long product = sub * (tot - sub);
        max = Math.max(max, product);

        return sub;
    }

    public int maxProduct(TreeNode root) {
        tot = 0;
        max = 0;
        sum(root);
        help(root);
        return (int)(max % MOD);
    }
}
