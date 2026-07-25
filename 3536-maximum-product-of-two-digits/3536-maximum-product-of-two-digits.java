class Solution {
    public int maxProduct(int n) {
        // int ans=1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(n>0){
            int  r = n%10;
            ans.add(r);
            n/=10;
        }
        Collections.sort(ans,Collections.reverseOrder());
        return ans.get(0)*ans.get(1);
        
    }
}