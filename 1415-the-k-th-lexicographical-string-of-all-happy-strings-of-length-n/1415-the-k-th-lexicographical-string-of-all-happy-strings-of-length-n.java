class Solution {
    TreeSet<String> ans;
    public void help(String s , int n ){
        if(s.length()==n){
            ans.add(s);
            return;
        }
        for(char ch='a'; ch<='c'; ch++){
            if(s.length()==0 || ch!=s.charAt(s.length()-1)){
                help(s+ch,n);
            }
        }
    }
    public String getHappyString(int n, int k) {
        ans = new TreeSet<>();
        help("", n);
        if(ans.size()<k) return "";
        int idx =0;
        for(String a : ans){
            if(idx==k-1) return a;
            idx++;
        }
        return "";
    }
}