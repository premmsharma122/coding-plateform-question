class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, List<Integer>> lw = new HashMap<>();
        HashMap<Character, List<Integer>> up = new HashMap<>();
        int c=0;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                up.putIfAbsent(ch,new ArrayList<>());
                up.get(ch).add(i);
            }
        }
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                lw.putIfAbsent(ch,new ArrayList<>());
                lw.get(ch).add(i);
            }
        }
        for(char a : lw.keySet()){
            List<Integer> l = lw.get(a);
            List<Integer> u = up.getOrDefault(Character.toUpperCase(a),new ArrayList<>());
            Collections.sort(l);
            Collections.sort(u);
            if(l.size()>0 && u.size()>0){
            if(l.get(l.size()-1)<u.get(0)){
                c++;
            }
            }
        }
        return c;
    }
}