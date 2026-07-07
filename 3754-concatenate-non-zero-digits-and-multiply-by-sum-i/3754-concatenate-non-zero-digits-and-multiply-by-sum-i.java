class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        char arr[] = String.valueOf(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        long s=0;
        for(char a : arr){
            if(a!='0'){
                sb.append(a);
                s=s+(a-'0');
            }
        }
        return Long.parseLong(sb.toString()) * s;
    }
}