class Solution {
    public int numOfSubarrays(int[] arr) {
        // List<List<Integer>> list = new ArrayList<>();
        // for(int i=0; i<arr.length; i++){
        //      List<Integer> curr = new ArrayList<>();
        //     for(int j=i; j<arr.length; j++){
               
        //         curr.add(arr[j]);
        //         list.add(new ArrayList<>(curr));
        //     }
            
        
        // }
        // int c=0;
        // for(int i=0; i<list.size(); i++){
        //     int sum =0;
        //     for(int j=0; j<list.get(i).size(); j++){
        //         sum+= list.get(i).get(j);
        //     }
        //     if(sum%2 != 0){
        //         c++;
        //     }
        // }

        // return c;

        // >>>> OPTIMIZE BY PRE-FIX SUM <<<<<<
        int oddCount = 0, evenCount = 1, sum = 0, result = 0;
        int MOD = 1_000_000_007;
        
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }
        
        return result;
    }
}
