class Solution {
    int res = 0;

    int help(Node r) {
        if (r == null) return 0;

        int left = help(r.left);
        int right = help(r.right);

        
        int dia = left + right + 1;
        res = Math.max(res, dia);

        
        return 1 + Math.max(left, right);
    }

    int diameter(Node root) {
        res = 0;
        help(root);
        return res;
    }
}
