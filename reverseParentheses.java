// class Solution {
//     public String reverseParentheses(String s) {
//         Stack<String> st = new Stack<>();
//         int i = 0;

//         while (i < s.length()) {
//             if (s.charAt(i) == '(') {
//                 StringBuilder sb = new StringBuilder();
//                 i++;

//                 while (i < s.length() && s.charAt(i) != ')') {
//                     if (s.charAt(i) == '(') {
//                         st.push(sb.toString());
//                         sb.setLength(0);
//                     } else {
//                         sb.append(s.charAt(i));
//                     }
//                     i++;
//                 }

//                 sb.reverse();

//                 if (!st.isEmpty()) {
//                     String temp = st.pop();
//                     sb.insert(0, temp);
//                 }

//                 st.push(sb.toString());
//             }

//             i++;
//         }

//         StringBuilder sb = new StringBuilder();
//         for (String a : st) {
//             sb.append(a);
//         }

//         return sb.toString();
//     }
// }

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(current);
                current = new StringBuilder();

            } else if (ch == ')') {
                current.reverse();

                StringBuilder previous = stack.pop();
                previous.append(current);

                current = previous;

            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}
