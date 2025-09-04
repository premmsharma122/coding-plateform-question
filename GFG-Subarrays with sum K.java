class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int c=0;
        int sum=0;
        for(int n : arr){
            sum+=n;
            c+= hm.getOrDefault(sum-k,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return c;
    }
}
