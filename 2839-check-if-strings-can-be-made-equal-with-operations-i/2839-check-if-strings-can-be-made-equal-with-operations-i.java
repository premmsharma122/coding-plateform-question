class Solution {
    public boolean canBeEqual(String s1, String s2) {
        StringBuilder str1 = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(s2);

        if(str1.charAt(0)!=str2.charAt(0)){
            char tmp=str1.charAt(2);
            str1.setCharAt(2,str1.charAt(0));
            str1.setCharAt(0,tmp);
        }
        if(str1.charAt(1)!=str2.charAt(1)){
             char tmp=str1.charAt(1);
            str1.setCharAt(1,str1.charAt(3));
            str1.setCharAt(3,tmp);
        }
        return str1.toString().equals(str2.toString());
    }
}