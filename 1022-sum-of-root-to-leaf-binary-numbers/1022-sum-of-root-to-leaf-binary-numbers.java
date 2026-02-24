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
    List<String> ans;
    public void help(TreeNode r, String cur){
        if(r==null){
            return;
        }

        cur+=(r.val+"");
        if(r.left==null && r.right==null) {
            ans.add(cur);
            return;
        }
        help(r.left,cur);
        help(r.right,cur);
    }
    public int sumRootToLeaf(TreeNode root) {
        ans = new ArrayList<>();
        help(root,"");
        int res=0;
        for(String a : ans){
            int num = Integer.parseInt(a,2);
            res+=num;
        }
        return res;
    }
}