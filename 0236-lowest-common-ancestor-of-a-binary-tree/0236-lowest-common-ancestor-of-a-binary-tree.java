/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean help(TreeNode r, TreeNode trg, List<TreeNode> arr){
        if(r==null) return false;
        arr.add(r);
        if(r.val==trg.val) return true;
        boolean lf = help(r.left,trg,arr);
        boolean rg = help(r.right,trg,arr);
        if(lf || rg) return true;
        arr.remove(arr.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> lf = new ArrayList<>();
        List<TreeNode> rg = new ArrayList<>();
        boolean a1 = help(root,p,lf);
        boolean a2 = help(root,q,rg);
        TreeNode lca=null;

        int i=0;
        for(;i<lf.size() && i<rg.size(); i++){
            if(lf.get(i)!=rg.get(i)) break;
        }
        return lf.get(i-1);
    }
}