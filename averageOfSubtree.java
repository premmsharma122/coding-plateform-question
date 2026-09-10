class Solution {

    int ans = 0;

    public int[] avg(TreeNode r) {

        if (r == null) {
            return new int[]{0, 0};
        }

        int[] left = avg(r.left);
        int[] right = avg(r.right);

        int sum = r.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        if (sum / count == r.val) {
            ans++;
        }

        return new int[]{sum, count};
    }

    public int averageOfSubtree(TreeNode root) {
        avg(root);
        return ans;
    }
}
