class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int n =0, c=0;
        for(int nm : arr){
            n ^= nm;
            int trg = n ^k;
            if(hm.containsKey(trg)){
                c+= hm.get(trg);
            }
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        return c;
        
    }
}
