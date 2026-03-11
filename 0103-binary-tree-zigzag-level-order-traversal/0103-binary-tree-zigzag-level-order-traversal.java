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
    public void help(TreeNode r, List<List<Integer>> arr){
        if(r==null) return;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);
        boolean left=true;
        while(!q.isEmpty()){
            int s =q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<s; i++){
                TreeNode cur  = q.poll();
                if(left){
                    l.add(cur.val);
                }else{
                    l.add(0,cur.val);
                }
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            arr.add(l);
            left=!left;
        }
        
        
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> ans = new ArrayList<>();
    help(root,ans);
    return ans;
    }
}