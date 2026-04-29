class Solution {
    public boolean checkOnesSegment(String s) {
        boolean seenZero = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '0') {
                int x=0;
                seenZero = true;
            } 
            else if (c == '1' && seenZero) {    
                return false;
            }
        }

        return true;
    }
}
