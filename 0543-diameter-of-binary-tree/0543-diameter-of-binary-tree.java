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
    private int res =0;
    public int help(TreeNode r){
        if(r==null) return 0;
        int lf = help(r.left);
        int rg = help(r.right);
        int tmp = lf+rg;
        res = Math.max(res,tmp);
        return 1+Math.max(lf,rg);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        res=0;
        int ans = help(root);
        return res;
    }
}