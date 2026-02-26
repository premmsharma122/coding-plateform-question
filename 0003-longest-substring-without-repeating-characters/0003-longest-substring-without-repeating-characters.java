class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int i=0,j=0,m=0;
        while(j<s.length()){
            if(!hs.contains(s.charAt(j))){
                hs.add(s.charAt(j));
                m= Math.max(m,j-i+1);
                j++;
            }else{
                hs.remove(s.charAt(i));
                i++;
            }
        }
        return m;
    }
}