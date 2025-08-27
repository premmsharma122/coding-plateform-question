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
    private int res = Integer.MIN_VALUE;
    public int help(TreeNode r){
        if(r==null) return 0;
        int ri = Math.max(0, help(r.right));
        int left = Math.max(0,help(r.left));
        res = Math.max(res, ri + left +r.val);
        return r.val + Math.max(ri, left);
    }
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        int ans = help(root);
        return res;
    }
}
