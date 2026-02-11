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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lvl=0;
        while(!q.isEmpty()){
            int s=q.size();
            int prev = (lvl%2==0 ? Integer.MIN_VALUE : Integer.MAX_VALUE);

            for(int i=0; i<s; i++){
                TreeNode cur=q.poll();
                int v = cur.val;
                if(lvl%2==0){
                    if(v%2==0 || v<=prev) return false;
                }
                else {
                    if(v%2!=0 || v>=prev) return false;
                }
                prev = v;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            lvl++;
        }
        return true;
    }
}