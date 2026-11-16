class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            StringBuilder ans = new StringBuilder();
            int c=0; int turn =0;
            for(int i=0; i<s.length(); i++){
                turn += Integer.parseInt(String.valueOf(s.charAt(i)));
                c++;

                if(c==k){
                    ans.append(turn);
                    turn =0;
                    c=0;
                }

            }
            if(c>0){
                ans.append(turn);
            }

            s= ans.toString();
        }
        return s;
    }
}
