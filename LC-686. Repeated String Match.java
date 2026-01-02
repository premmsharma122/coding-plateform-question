class Solution {
    public int repeatedStringMatch(String a, String b) {
        String s = "";
        int c=0;
        while(s.length() < a.length()+b.length()){
            s+=a;
            c++;
            if(s.contains(b)) return c;
        }
        return -1;
    }
}
