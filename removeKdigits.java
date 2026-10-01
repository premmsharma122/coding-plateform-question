class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<num.length()){
            while(k>0 && i<num.length() && !st.isEmpty() && st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }
            st.add(num.charAt(i));
            i++;
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        for(Character a : st){
            ans.append(a);
        }
        while(ans.length()>1 && ans.charAt(0)=='0')
            ans.deleteCharAt(0);

        return ans.toString();
        
    }
}
