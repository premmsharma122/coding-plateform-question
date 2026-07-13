class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        
        List<Integer> ans= new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                String cur = s.substring(i,j+1);
                int n = Integer.parseInt(cur);
                if(n<=high && n>=low) ans.add(n);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}