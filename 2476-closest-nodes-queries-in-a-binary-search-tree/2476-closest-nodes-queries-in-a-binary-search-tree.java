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
    static ArrayList<Integer> arr;
    public void inorder(TreeNode rt){
        if(rt==null) return;
        inorder(rt.left);
        arr.add(rt.val);
        inorder(rt.right); 
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        arr= new ArrayList<>();
        inorder(root);
        List<List<Integer>> ans= new ArrayList<>();
        for(int q : queries){
            int f=-1, c=-1;
            int l=0, r=arr.size()-1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(arr.get(mid)==q){
                    f=arr.get(mid);
                    c=arr.get(mid);
                    break;
                }else if(arr.get(mid)<q){
                    f=arr.get(mid);
                    l=mid+1;
                }else{
                    c=arr.get(mid);
                    r=mid-1;
                }
            }
            ans.add(Arrays.asList(f,c));
        }
        return ans;
    }
}