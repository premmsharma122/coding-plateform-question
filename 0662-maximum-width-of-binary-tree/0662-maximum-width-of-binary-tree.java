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
    public int widthOfBinaryTree(TreeNode root) {
        int maxw =0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min= q.peek().getValue();
            int first=0, last=0;
            for(int i=0; i<size; i++){
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode n = p.getKey();
                int idx= p.getValue()-min;
                if(i==0) first=idx;
                if(i==size-1) last = idx;
                if(n.left != null){
                    q.offer(new Pair<>(n.left,2*idx+1));
                }
                if(n.right!=null){
                    q.offer(new Pair<>(n.right, 2*idx+2));
                }

            }
            maxw=Math.max(maxw, last-first+1);
        }
        return maxw;
    }
}