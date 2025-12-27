// >>>> HELP from Solution...<<< (Added)
class Solution {
    int cameras = 0;

    // returns state
    // 0 = not covered
    // 1 = has camera
    // 2 = covered
    public int dfs(TreeNode node) {
        if (node == null) return 2; // null is considered covered

        int left = dfs(node.left);
        int right = dfs(node.right);

        // Case 1: if any child is not covered
        if (left == 0 || right == 0) {
            cameras++;
            return 1; // place camera here
        }

        // Case 2: if any child has camera
        if (left == 1 || right == 1) {
            return 2; // this node is covered
        }

        // Case 3: children are covered but no camera
        return 0; // this node is not covered
    }

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) cameras++; // root not covered
        return cameras;
    }
}
