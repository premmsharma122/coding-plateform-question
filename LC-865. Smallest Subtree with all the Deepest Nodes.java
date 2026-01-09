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
    public int mx(TreeNode r){
        if(r==null) return 0;
        return 1 + Math.max(mx(r.left), mx(r.right));
    }
    public TreeNode dfs(TreeNode rt, int dep, int max){
        if(rt==null) return null;
        if(dep==max) return rt;
        TreeNode left = dfs(rt.left,dep+1,max);
        TreeNode right = dfs(rt.right,dep+1,max);
        if(left != null && right != null) return rt;
        return left ==null? right:left;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int m = mx(root);
        return dfs(root,1,m);
    }
}
