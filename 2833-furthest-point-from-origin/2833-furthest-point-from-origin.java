class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int L=0,R=0,ds=0;
        if(moves.length()==1){
            return 1;
        }
        for(char a : moves.toCharArray()){
            if(a=='L') L++;
            else if(a=='R') R++;
            else ds++;
        }
        int ans = Math.abs(L-R);
        return ans +ds;
        
       
    }
}