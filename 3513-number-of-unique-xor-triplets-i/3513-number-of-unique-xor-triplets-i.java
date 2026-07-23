class Solution {
    public int uniqueXorTriplets(int[] nums) {
    //     HashMap<Integer, Integer> hm = new HashMap<>();
    //     for(int i=1; i<=nums.length; i++){
    //         int xor1=i;
    //       for(int j=i; j<=nums.length; j++){
    //         int xor2=xor1^j;
    //         hm.put(xor2,hm.getOrDefault(xor2,0)+1);
    //       }
    //     }
    //     HashSet<Integer> hs = new HashSet<>();
    //    for(int v : hm.values()){
    //     for(int i=1; i<=nums.length; i++){
    //         int x= v^i;
    //         hs.add(x);
    //     }
    //    }
    //    return hs.size();
     int n = nums.length;

        if (n == 1 || n == 2)
            return n;

        int ans = 1; // 2^0
        while (ans <= n) {
            ans = (ans << 1);
        }

        return ans;
    }
}