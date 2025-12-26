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
    public List<TreeNode> help(int st, int ed){
        List<TreeNode> res= new ArrayList<>();
        if(st>ed) {
            res.add(null);
            return res;
        }
        for(int i=st; i<=ed; i++){
            List<TreeNode> left = help(st,i-1);
            List<TreeNode> right = help(i+1,ed);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode rt = new TreeNode(i,l,r);
                    res.add(rt);
                }
            }
        }
        return res;
    }
    public List<TreeNode> generateTrees(int n) {
        return help(1,n);
    }
}
