class Solution {
    public int help(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    if (b == 0) return a;
    int min = Math.min(a, b);
    int ans = 1;  
    for (int i = 2; i <= min; i++) {
        if (a % i == 0 && b % i == 0) {
            ans = i;
        }
    }
    return ans;
}

    public int maxPoints(int[][] points) {
        int max =0;
        for(int i=0; i<points.length; i++){
            HashMap<String, Integer> hm = new HashMap<>();
            int overlap =0 , verticle =0, curr=0;
            for(int j=i+1; j<points.length; j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                if(dx==0 && dy==0){
                    overlap++;
                }
                else if(dx ==0){
                    verticle++;
                    curr = Math.max(curr,verticle);
                }
                else{
                    int gcd = help(dx,dy);
                    dx= dx/gcd;
                    dy= dy/gcd;
                    if(dx <0){
                        dx *=-1;
                        dy*=-1;
                    }
                    String slp = dy +"/"+dx;
                    hm.put(slp, hm.getOrDefault(slp,0)+1);
                    curr = Math.max(curr, hm.getOrDefault(slp,0));
                }

            }
            max = Math.max(curr+overlap+1, max);
        }
        return max;
    }
}
