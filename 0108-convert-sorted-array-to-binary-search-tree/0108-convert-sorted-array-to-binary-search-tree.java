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
    public TreeNode help(int l, int r, int n[]){
        if(l>r) return null;
        int mid = (r+l)/2;
        TreeNode rot = new TreeNode(n[mid]);
        rot.left = help(l,mid-1,n);
        rot.right = help(mid+1,r,n);
        return rot;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(0,nums.length-1,nums);
    }
}