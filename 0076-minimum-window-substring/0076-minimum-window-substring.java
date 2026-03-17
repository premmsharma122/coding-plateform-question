class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        for(char a : t.toCharArray()){
            need.put(a,need.getOrDefault(a,0)+1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int needc=need.size(),left=0,min=Integer.MAX_VALUE,have=0,start=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            window.put(ch,window.getOrDefault(ch,0)+1);

            if(need.containsKey(ch) && window.get(ch).equals(need.get(ch))){
                have++;
            }
            while(needc==have){
                char leftchar = s.charAt(left);
                if(i-left+1<min){
                    min=i-left+1;
                    start=left;
                }
                window.put(leftchar,window.get(leftchar)-1);
                if(need.containsKey(leftchar) && window.get(leftchar)<need.get(leftchar)){
                    have--;
                }
                left++;
            }
        }
        return min== Integer.MAX_VALUE ? "": s.substring(start,start+min);

        
    }
}