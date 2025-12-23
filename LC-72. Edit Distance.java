class Solution {
    public int help(String s1, String s2, int i, int j, int memo[][]){
        if(i==s1.length()){
            return s2.length()-j;
        }else if(j==s2.length()){
            return s1.length()-i;
        }
        if(memo[i][j] !=-1 ) return memo[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
           return memo[i][j] = help(s1,s2,i+1,j+1,memo);
        }else{
        int ins = 1+help(s1,s2,i,j+1,memo);
        int del = 1+help(s1,s2,i+1,j,memo);
        int rep = 1+help(s1,s2,i+1,j+1,memo);
        
        return memo[i][j] = Math.min(ins, Math.min(del,rep));
        }
        
    }
    public int minDistance(String word1, String word2) {
        int memo[][] =new int[501][501];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        return help(word1,word2,0,0,memo);
    }
}
