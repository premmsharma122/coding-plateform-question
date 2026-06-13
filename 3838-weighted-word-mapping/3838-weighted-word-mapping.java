class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for(String s : words){
            int sm=0;
            for(char a : s.toCharArray()){
                int idx = a-'a';
                sm+=weights[idx];
            }
            sm=sm%26;
            char a = (char)('a' + (26 - sm-1));
            sb.append(a);
        }
        return sb.toString();
    }
}