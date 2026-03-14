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
    public boolean help(TreeNode r, TreeNode l){
        if(r==null && l==null) return true;
        if(r==null || l==null || r.val !=l.val) return false;
        return help(r.right , l.left) && help(r.left, l.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return help(root.right, root.left);
    }
}