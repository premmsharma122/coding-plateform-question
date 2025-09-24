class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder sb = new StringBuilder();

        if((numerator<0) ^ (denominator<0)) sb.append("-");
        long nm = Math.abs((long) numerator);
        long dm = Math.abs((long) denominator);

        sb.append(nm/dm);
        long rem = nm % dm;
        if(rem == 0 ) return sb.toString();
        sb.append(".");
        HashMap<Long, Integer> hm = new HashMap<>();

        while(rem != 0){
            if(hm.containsKey(rem)){
                int idx = hm.get(rem);
                sb.insert(idx,'(');
                sb.append(")");
                break;
            }
            hm.put(rem, sb.length());
            rem = rem*10;
            sb.append(rem/dm);
            rem %=dm;

        }
        return sb.toString();
    }
}
