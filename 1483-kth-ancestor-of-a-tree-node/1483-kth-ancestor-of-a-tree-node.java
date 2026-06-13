class TreeAncestor {
    private int anc[][];
    private int Log;

    public TreeAncestor(int n, int[] parent) {
        Log = (int) (Math.log(n)/Math.log(2))+1;
        anc= new int[n][Log];
        for(int i=0; i<n; i++){
            for(int j=0; j<Log; j++){
                anc[i][j]=-1;
            }
        }

        for(int i=0; i<n; i++){
            anc[i][0]=parent[i];
        }
        for(int i=1; i<Log; i++){
            for(int j=0; j<n; j++){
                int prev = anc[j][i-1];
                if(prev !=-1){
                    anc[j][i] = anc[prev][i-1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int j=0; j<Log && node!=-1; j++){
            if((k & (1 << j)) !=0){
                node = anc[node][j];
                if(node ==-1) return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */