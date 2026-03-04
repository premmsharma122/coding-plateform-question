class Solution {
    Boolean dp[];
    public boolean help(String s, List<String> wd , int idx){
        if(idx==s.length()) return true;
        if(dp[idx]!=null) return dp[idx];
        for(int i=0; i<wd.size(); i++){
            String w = wd.get(i);
            if(idx+w.length()<=s.length() && s.substring(idx,idx+w.length()).equals(w)){
                if(help(s,wd,idx+w.length())) return  dp[idx]=  true;
            }
        }
        return dp[idx]= false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return help(s,wordDict, 0);
    }
}