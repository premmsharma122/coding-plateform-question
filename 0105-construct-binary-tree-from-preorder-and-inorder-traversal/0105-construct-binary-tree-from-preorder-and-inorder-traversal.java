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
 //help from solution for better approach
 class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
        if (inStart > inEnd) return null; // Base case: No elements to construct subtree

        // Create the root node from preorder
        TreeNode root = new TreeNode(preorder[preIndex]);

        // Find index of root in inorder
        int index = inStart;
        while (inorder[index] != preorder[preIndex]) {
            index++;
        }

        // Recursively build left and right subtrees
        root.left = construct(preorder, inorder, preIndex + 1, inStart, index - 1);
        root.right = construct(preorder, inorder, preIndex + (index - inStart) + 1, index + 1, inEnd);

        return root;
    }
}