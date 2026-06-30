class Solution {
   public boolean help(HashMap<Character, Integer> hm){
    return hm.containsKey('a')
        && hm.containsKey('b')
        && hm.containsKey('c');
}
    public int numberOfSubstrings(String s) {
        int j=0,i=0,ans=0,n=s.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        while (j < n) {

            hm.put(s.charAt(j),
                    hm.getOrDefault(s.charAt(j), 0) + 1);

            while (help(hm)) {

                ans += s.length() - j;

                if(hm.containsKey(s.charAt(i))){
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                }

                if (hm.get(s.charAt(i)) == 0)
                    hm.remove(s.charAt(i));

                i++;
            }

            j++;
        }
        return ans;
    }
}