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
    public int help(TreeNode r){
        if(r==null) return 0;
        int l = help(r.left);
        int rt=help(r.right);
        return l+rt+1;
    }
    public int countNodes(TreeNode root) {
        int ans = help(root);
        return ans;
    }
}