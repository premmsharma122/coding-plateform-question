class Solution {
    public int numberOfSpecialChars(String word) {
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for(int i=0; i<word.length(); i++){
        //     char ch = Character.toLowerCase(word.charAt(i));
        //     hm.put(ch-'a',hm.getOrDefault(ch-'a',0)+1);
        // }
        // int c=0;
        // for(int a : hm.keySet()){
        //     if(hm.get(a)>=2){
        //         c++;
        //     }
        // }
        // return c;
        HashSet<Character> hs = new HashSet<>();
        int c= 0;
        for(char a : word.toCharArray()){
            hs.add(a);
        }
        boolean sen[] = new boolean[26];

        for(int i=0; i<word.length(); i++){
             if(Character.isLowerCase(word.charAt(i)) && !sen[word.charAt(i)-'a']){
                if(hs.contains(Character.toUpperCase(word.charAt(i)))){
                    c++;
                    sen[word.charAt(i)-'a']=true;
                }
            }
        }
        return c;
    }
}