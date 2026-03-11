/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    boolean leaf(Node r){
        if(r.left== null && r.right==null) return true;
        return false;
    }
    void addleft(Node r, ArrayList<Integer> arr){
        Node cur = r.left;
        while(cur!=null){
            if(!leaf(cur)) arr.add(cur.data);
            if(cur.left!=null) cur=cur.left;
            else cur= cur.right;
        }
        
    }
    void addright(Node r, ArrayList<Integer> arr){
        Node cur = r.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while(cur!=null){
            if(!leaf(cur)) tmp.add(cur.data);
            if(cur.right!=null) cur=cur.right;
            else cur= cur.left;
        }
        for(int i=tmp.size()-1; i>=0; i--){
            arr.add(tmp.get(i));
        }
        
    }
    void leafadd(Node r, ArrayList<Integer> arr){
        if(leaf(r)) {
            arr.add(r.data);
            return;
        }
        if (r.left!=null) leafadd(r.left, arr);
        if (r.right!=null) leafadd(r.right, arr);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        
        ArrayList<Integer> arr= new ArrayList<>();
        if(!leaf(root)) arr.add(root.data);
        addleft(root,arr);
        leafadd(root,arr);
        addright(root,arr);
        return arr;
        
    }
}
