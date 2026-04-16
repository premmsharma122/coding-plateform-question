class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.putIfAbsent(nums[i],new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int q : queries){
            int val  = nums[q];
            ArrayList<Integer> arr = hm.get(val);
            if(arr.size()==1){
                res.add(-1);
                continue;
            }
            int min = Integer.MAX_VALUE;
            int idx = Collections.binarySearch(arr,q);
            int left = (idx-1+arr.size())%arr.size();
            int leftval = arr.get(left);
            int d1 = Math.abs(q-leftval);
            d1 = Math.min(d1,nums.length-d1 );
            min= Math.min(d1,min);

            int right = (idx+1)%arr.size();
            int rightVal  =arr.get(right);
            int d2 = Math.abs(q-rightVal);
            d2 = Math.min(d2,nums.length-d2);
            min=Math.min(d2,min);
            res.add(min);
        }
        return res;
    }
}