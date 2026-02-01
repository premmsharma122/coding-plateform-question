class Solution {
    public int maxResult(int[] nums, int k) {
        // int dp[][] = new int[nums.length][nums.length];
        // for(int i=0; i<nums.length; i++){
        //     for(int j=0; j<nums.length; j++){
        //         dp[i][j] = nums[i] + nums[j];
        //     }
        // }
        // int max=0;
        // for(int i=0; i<nums.length; i++){
        //     int tmp=Integer.MIN_VALUE;
        //     for(int j=0; j<nums.length; j++){
        //         tmp = Math.max(tmp , dp[i][j]);
        //     }
        //     max = Math.max(max, tmp);
        // }
        // return max;
        Deque<Integer> dq = new LinkedList<>();
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dq.add(0);

        for(int i=1; i<nums.length; i++){
            while(!dq.isEmpty() && i-k > dq.peekFirst()){
                dq.pollFirst();
            }
            dp[i] = nums[i] + dp[dq.peekFirst()];
            while(!dq.isEmpty() && dp[i] >= dp[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return dp[nums.length-1];
    }
}
