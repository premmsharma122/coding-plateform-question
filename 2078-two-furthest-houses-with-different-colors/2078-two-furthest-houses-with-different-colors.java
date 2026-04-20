class Solution {
    public int maxDistance(int[] colors) {
        int i=0, j=colors.length-1;
        int max = Integer.MIN_VALUE;
        while(i<=j){
            if(colors[i]!=colors[j]){
                max = Math.max(max,Math.abs(i-j));
                i++;
                j--;
            }
            else{
                i++;
            }
        }
        i=0;
        j=colors.length-1;
        int max2=Integer.MIN_VALUE;
         while(i<=j){
            if(colors[i]!=colors[j]){
                max2 = Math.max(max2,Math.abs(i-j));
                i++;
                j--;
            }
            else{
                j--;
            }
        }
        return Math.max(max,max2);
    }
}