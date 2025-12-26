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
    public int[] help(TreeNode r){
        if(r==null) return new int[]{0,0};
        int lf[] = help(r.left);
        int rg[] = help(r.right);

        int ans1 = r.val + lf[1] + rg[1];
        int ans2 = Math.max(lf[0], lf[1] ) + Math.max(rg[1],rg[0]);
        return new int[]{ans1,ans2};

    }
    public int rob(TreeNode root) {
        int res[] = help(root);
        return Math.max(res[0],res[1]);

    }
}
