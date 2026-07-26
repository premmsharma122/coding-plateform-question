class Solution {
    public int maximumProduct(int[] nums) {
         Arrays.sort(nums);
     List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int max = Integer.MIN_VALUE;
        int cont = 1;
        int n=3;
    while(n>0){
        max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
           max = Math.max(max, list.get(i));
        }
        cont = max*cont;
        list.remove(Integer.valueOf(max));
        n--;
    }
     int maxProduct2 = nums[0] * nums[1] * nums[nums.length - 1];
     return Math.max(maxProduct2, cont);
    }
   
}