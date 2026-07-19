class Solution {
    public String smallestSubsequence(String s) {
         Stack<Character> st = new Stack<>();
        HashSet<Character> hs = new HashSet<>();
        int f[] = new int[26];
        for(int i=0; i<s.length(); i++){
            f[s.charAt(i)-'a'] =i;
        }
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(hs.contains(a)) continue;
            while(!st.isEmpty() && st.peek()>a && f[st.peek()-'a'] >i){
                hs.remove(st.pop());
            }
            st.push(a);
            hs.add(a);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }
        return sb.toString();
    }
}