class Solution {
    public int minNumberOperations(int[] target) {
        int c=target[0], tm=target[0];
        for(int i=1; i<target.length; i++){
            if(tm < target[i]){
                c += target[i]-tm;
            }
            tm = target[i];
        }
        return c;
    }
}
