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

    HashMap<Integer, List<int[]>> graph = new HashMap<>();

    public TreeNode build(int val) {
        TreeNode root = new TreeNode(val);

        if (!graph.containsKey(val))
            return root;

        for (int[] childInfo : graph.get(val)) {
            int child = childInfo[0];
            int isLeft = childInfo[1];

            if (isLeft == 1) {
                root.left = build(child);
            } else {
                root.right = build(child);
            }
        }

        return root;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {

        HashSet<Integer> children = new HashSet<>();
        for (int[] d : descriptions) {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];

            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(new int[]{child, isLeft});

            children.add(child);
        }

        int rootVal = -1;

        for (int[] d : descriptions) {
            if (!children.contains(d[0])) {
                rootVal = d[0];
                break;
            }
        }

        return build(rootVal);
    }
}