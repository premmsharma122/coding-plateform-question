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
     public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();   
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode cur = q.poll();
                level.add(cur.val);

                if(cur.left != null)
                    q.add(cur.left);

                if(cur.right != null)
                    q.add(cur.right);
            }

            ans.add(level);  
        }

        return ans;
    }
    public boolean alleven(List<Integer> ar){
        for(int a : ar){
            if(a%2!=0) return false;
        }
        return true;
    }
    public boolean allodd(List<Integer> ar){
        for(int a : ar){
            if(a%2==0) return false;
        }
        return true;
    }
    public boolean dec(List<Integer> ar){
        if(ar.size()==1) return true;
        for(int i=1; i<ar.size(); i++){
            if(ar.get(i-1)<=ar.get(i)) return false;
        }
        return true;
    }
    public boolean inc(List<Integer> ar){
        if(ar.size()==1) return true;
        for(int i=1; i<ar.size(); i++){
            if(ar.get(i-1)>=ar.get(i)) return false;
        }
        return true;
    }
    
    public boolean isEvenOddTree(TreeNode root) {
      List<List<Integer>> arr = levelOrder(root);
      for(int i=0; i<arr.size(); i++){
        if(i%2!=0){
            if(!alleven(arr.get(i)) || !dec(arr.get(i)) ) return false;
        }
        else{
            if(!allodd(arr.get(i)) || !inc(arr.get(i))) return false;
        }
      }
      return true;
    }
}