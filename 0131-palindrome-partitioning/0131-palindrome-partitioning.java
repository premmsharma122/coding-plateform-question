class Solution {
    public void part(String s, int start, List<String> p, List<List<String>> ans){
        if(s.length()==start){
            ans.add(new ArrayList<>(p));
            return;
        }

        for(int i=start+1; i<=s.length(); i++){
            if(isPalin(s, start, i-1)){
                p.add(s.substring(start, i));
                part(s,i,p, ans);
                // backtrack
                p.remove(p.size()-1);
            }
        }
    }
    public boolean isPalin(String s , int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> p = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        part(s,0,new ArrayList<>(),ans);
        return ans;
    }
}