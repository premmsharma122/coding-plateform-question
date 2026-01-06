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
    HashMap<Integer, Integer> hm;

    public void help(TreeNode r, int level) {
        if (r == null) return;        
        hm.put(level, hm.getOrDefault(level, 0) + r.val);
        help(r.left, level + 1);
        help(r.right, level + 1);
    }
    public int maxLevelSum(TreeNode root) {
        hm = new HashMap<>();
        help(root, 1);
        int maxSum = Integer.MIN_VALUE;
        int ansLevel = 1;
        for (int level : hm.keySet()) {
            if (hm.get(level) > maxSum) {
                maxSum = hm.get(level);
                ansLevel = level;
            }
        }
        return ansLevel;
    }
}
