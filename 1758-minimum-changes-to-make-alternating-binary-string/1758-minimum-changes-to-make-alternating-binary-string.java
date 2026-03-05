class Solution {
    public int minOperations(String s) {
        int c=0;
        StringBuilder sb  = new StringBuilder(s);
        for(int i=1; i<sb.length(); i++){
            if(sb.charAt(i-1)=='0'){
                if(sb.charAt(i)!='1') {
                    sb.setCharAt(i,'1');
                    c++;
                }
            }else if(sb.charAt(i-1)=='1'){
                if(sb.charAt(i)!='0') {
                    sb.setCharAt(i,'0');
                    c++;
                }
            }
        }
            StringBuilder sb2 = new StringBuilder(s);
            int c2=0;
            if(s.charAt(0)=='1'){
                sb2.setCharAt(0,'0');
                c2++;
            }else if(s.charAt(0)=='0'){
                sb2.setCharAt(0,'1');
                c2++;
            }
        
            for(int i=1; i<s.length(); i++){
                if(sb2.charAt(i-1)=='0'){
                if(sb2.charAt(i)!='1') {
                    sb2.setCharAt(i,'1');
                    c2++;
                }
            }else if(sb2.charAt(i-1)=='1'){
                if(sb2.charAt(i)!='0') {
                    sb2.setCharAt(i,'0');
                    c2++;
                }
            }
            }
        
        return Math.min(c,c2);
    }
}