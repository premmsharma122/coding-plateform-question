class Solution {
    class Pair{
        int idx,  c;
        Pair(int idx, int c){
            this.idx=idx;
            this.c=c;
        }

    }
    public int maxIceCream(int[] costs, int coins) {
        // Pair[] arr = new Pair[costs.length];
        // for(int i=0; i<costs.length; i++){
        //     arr[i] = new Pair(i,costs[i]);
        // }
        int s=0;
        // Arrays.sort(arr,(a,b)->b[0]-b[1]); // wnat to sort on the basis of cost 
        Arrays.sort(costs);
        int ct=0;
        for(int a : costs){
            int cs=a;
            if(s+cs<=coins) {
                s+=cs;
                ct++;
            }
        }
        return ct;
    }
}