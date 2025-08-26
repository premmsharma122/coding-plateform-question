import java.util.*;

class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean help(String s1, String s2){
        if(s1.equals(s2)) return true;
        if(s1.length() <= 1) return false;

        String key = s1 + "#" + s2;
        if(memo.containsKey(key)) return memo.get(key);

        int n = s1.length();
        boolean flag = false;

        for(int i=1; i<=n-1; i++){
            boolean c1 = help(s1.substring(0,i), s2.substring(n-i, n)) 
                      && help(s1.substring(i, n), s2.substring(0, n-i));

            boolean c2 = help(s1.substring(0,i), s2.substring(0,i)) 
                      && help(s1.substring(i, n), s2.substring(i, n));

            if(c1 || c2){
                flag = true;
                break;
            }
        }

        memo.put(key, flag);
        return flag;
    }

    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return help(s1, s2);
    }
}
