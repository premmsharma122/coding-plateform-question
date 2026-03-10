class Solution {
    public int minCostToMoveChips(int[] arr) {
        int ev=0, od=0;
        for(int i : arr){
            if(i%2==0) ev++;
            else od++;
        }
        return Math.min(ev,od);
    }
}