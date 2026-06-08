class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lower = new ArrayList<>();
        List<Integer> upper = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] < pivot ){
                lower.add(nums[i]);
            }else if( nums[i] > pivot){
                upper.add(nums[i]);
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] == pivot){
                lower.add(nums[i]);
            }
        }

        List<Integer> f = new ArrayList<>();
        int i=0,j=0;
        while(i<lower.size()){
            f.add(lower.get(i));
            i++;
        }
        while(j<upper.size()){
            f.add(upper.get(j));
            j++;
        }
        int ans[] = new int[f.size()];
       for(int k=0; k<f.size(); k++){
        ans[k] = f.get(k);
       }
        return ans;

    }
}