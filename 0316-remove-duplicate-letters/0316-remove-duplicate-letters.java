// class Solution {
//     public String removeDuplicateLetters(String s) {
//         ArrayList<String> res = new ArrayList<>();
//         ArrayList<String> ans = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
//         int i=0;
//         Stack<Character> st = new Stack<>();
//         HashSet<Character> hs = new HashSet<>();
//         while(i<s.length()){
//             char a = s.charAt(i);
//             if(st.isEmpty()){
//                 st.push(a);
//                 hs.add(a);
//                 sb.append(a);
//             }else if(!st.isEmpty() && !hs.contains(a)){
//                 st.push(a);
//                 sb.append(a);
//             }else if(!st.isEmpty() && hs.contains(a)){
//                 res.add(sb.toString());
//                 i=i-1;
//                 hs.clear();
//                 while(!st.isEmpty()){
//                     st.pop();
//                 }
//             }
//             i++;
//         }
//         int m=0;
//         for(String sr : res){
//             m = Math.max(sr.length(),m);
//         }
//         if(res.size()==1) return res.get(0);
//         for(int j=0; j<res.size(); j++){
//             if(res.get(j).length() ==m) ans.add(res.get(j));
//         }
//         String rs="";
//         if(ans.size()==1) return ans.get(0);
//         for(int k=1; k<ans.size(); k++){
//             if(ans.get(k-1).compareTo(ans.get(k)) < 0){
//                 rs=ans.get(k-1);
//             }else{
//                 rs=ans.get(k);
//             }
//         }
//         return rs;
//     }
// }
class Solution {
    public String removeDuplicateLetters(String s) {
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