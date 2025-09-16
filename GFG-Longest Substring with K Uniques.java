class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int i=0, j=0;
        int max = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        while(j<s.length()){
            hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
           
            if(hm.size()==k){
                max = Math.max(max,j-i+1);
            }else{
                while(hm.size()>k){
                   char a = s.charAt(i);
                   hm.put(a,hm.get(a)-1);
                   if(hm.get(a)==0) hm.remove(a);
                   i++;
                }
                
            }
            j++;
            
            
        }
        return max;
        
        
    }
}
