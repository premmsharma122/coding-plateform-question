class Solution {
    public void dup(StringBuilder sb){
        StringBuilder s = new StringBuilder(sb);
        sb.append(s);
    }

    public String processStr(String s) {
        StringBuilder sb= new StringBuilder();
        for(char a : s.toCharArray()){
            if(a=='#'){
                dup(sb);
            }else if(a=='%'){
                sb.reverse();
            }else if(a=='*' && sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
            }else if(a!='*'){
                sb.append(a);
            }
        }
        return sb.toString();
    }
}