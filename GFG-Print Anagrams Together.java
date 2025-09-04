class Solution {
    public boolean help(String s, String t){
        if(s.length() != t.length()) return false;
        int arr[] =new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            arr[t.charAt(i)-'a']--;
        }
        for(int a : arr){
            if(a!=0) return false;
        }
        return true;
    }
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        boolean seen[] = new boolean[arr.length];
        
        for(int i=0; i<arr.length; i++){
            if(seen[i]) continue;
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(arr[i]);
            seen[i]= true;
            for(int j=i+1; j<arr.length; j++){
                if(!seen[j] && help(arr[i],arr[j])){
                    
                    tmp.add(arr[j]);
                    seen[j] = true;
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
