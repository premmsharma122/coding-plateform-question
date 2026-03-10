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
    public void help(TreeNode a, List<String> str, String s ){
        if(a== null){
            return;
        }
        if(a.left == null && a.right == null){
            str.add(s + a.val );
            return;
        }
        help(a.left, str, s+a.val+ "->");
        help(a.right, str, s + a.val +"->");

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        help(root, ans,"");
        return ans;
    }
}