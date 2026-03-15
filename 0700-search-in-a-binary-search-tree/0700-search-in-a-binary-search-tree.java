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
    public TreeNode help(TreeNode r, int val){
        if(r==null) return null;
        if(r.val==val) return r;
        TreeNode right = help(r.right,val);
        TreeNode left = help(r.left,val);
        if(right!=null) return right;
        if(left!=null) return left;
        return null;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return help(root,val);
    }
}