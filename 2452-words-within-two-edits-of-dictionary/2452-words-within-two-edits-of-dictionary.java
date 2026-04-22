class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String w : queries) {
            for (String d : dictionary) {
                if (w.length() != d.length()) continue;
                int dif = 0;
                for (int i = 0; i < w.length(); i++) {
                    if (w.charAt(i) != d.charAt(i)) {
                        dif++;
                        if (dif > 2) break; 
                    }
                }
                if (dif <= 2) {
                    ans.add(w); 
                    break; 
                }
            }
        }

        return ans;
    }
}