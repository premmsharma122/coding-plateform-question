class Solution {
    public String invert(String s){
        StringBuilder sb = new StringBuilder();
        for(char a : s.toCharArray()){
            if(a=='1'){
                sb.append("0");
            }else{
                sb.append("1");
            }
        }
        return sb.toString();
    }
    public char findKthBit(int n, int k) {
        StringBuilder tm = new StringBuilder();
        tm.append("0");
        for(int i=2; i<=n; i++){
            String rest = tm.toString();
            tm.append("1");
            StringBuilder in = new StringBuilder(invert(rest));
            in.reverse();
            tm.append(in);
        }
        return tm.charAt(k-1);
    }
}