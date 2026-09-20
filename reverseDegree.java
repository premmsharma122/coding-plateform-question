class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int val = 26- (c-'a');
            int idx = i+1;
            ans+= val * idx;
        }
        return ans;
    }
}
