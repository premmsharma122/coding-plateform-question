class Solution {
    public String removeSubstring(String s, int k) {
        Stack<int[]> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0]==c){
                st.peek()[1]++;
            }else{
                st.push(new int[]{c,1});
            }
            int n=st.size();
            if(n>=2 && st.get(n-2)[0]=='(' && st.get(n-2)[1]>=k && st.get(n-1)[0]==')' && st.get(n-1)[1]==k){
                st.get(n-2)[1]-=k;
                st.pop();
                if(st.peek()[1]==0) st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p[]: st){
            char ch = (char) p[0];
            int cnt =p[1];
            for(int i=0; i<cnt; i++){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}
