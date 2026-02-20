class Solution {
    public String help(String s){
        int sum=0,st=0;
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            sum+=s.charAt(i)=='1'?1 : -1;
            if(sum==0){
                String inner = s.substring(st+1,i);
                ans.add("1"+help(inner)+"0");
                st=i+1;
            }
        }
        Collections.sort(ans,Collections.reverseOrder());
        StringBuilder res = new StringBuilder();
        for(String r : ans){
            res.append(r);
        }
        return res.toString();

    }
    public String makeLargestSpecial(String s) {
        return help(s);
    }
}