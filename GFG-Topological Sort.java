class Solution {
    public static void help(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int sen[], int i){
        sen[i] = 1;
        for(int a : adj.get(i)){
            if(sen[a]==0){
                help(adj,st,sen,a);
            }
        }
        st.push(i);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Stack<Integer> st = new Stack<>();
        int sen[] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u= edges[i][0];
            int v =edges[i][1];
            adj.get(u).add(v);
        }
        for(int i=0; i<V; i++){
            if(sen[i]==0){
                help(adj,st,sen,i);
            }
        }
        int c=0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(!st.isEmpty()){
            c = st.pop();
            arr.add(c);
        }
        return arr;
        
    }
}
