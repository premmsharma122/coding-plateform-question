class Solution {
    TreeNode tmp = new TreeNode();  
    TreeNode curr = tmp;
    public void help(TreeNode r){
        if(r == null) return;
        curr.right = r;
        curr.left = null;
        curr = curr.right;

        TreeNode left = r.left;
        TreeNode right = r.right;

        help(left);
        help(right);
    }

    public void flatten(TreeNode root) {
        help(root);
    }
}