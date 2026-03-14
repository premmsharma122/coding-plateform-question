/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean help(Node r){
        if(r==null) return true;
        if(r.left == null && r.right==null){
            return true;
        }
        int lf = r.left==null?0:r.left.data;
        int rg = r.right==null?0:r.right.data;
        if((lf+rg)!=r.data) return false;
        
        return help(r.right) && help(r.left);
    }
    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null) return true;
        return help(root);
        
        
    }
}
