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
    public int res = Integer.MIN_VALUE;
    public int help(TreeNode r){
        if(r==null) return 0;
        int rg = Math.max(0, help(r.right));
        int lf = Math.max(0, help(r.left));
        res = Math.max(res , rg+lf+r.val);
        return r.val + Math.max(rg,lf);
    }
    public int maxPathSum(TreeNode root) {
        res=Integer.MIN_VALUE;
        int ans = help(root);
        return res;
    }
}