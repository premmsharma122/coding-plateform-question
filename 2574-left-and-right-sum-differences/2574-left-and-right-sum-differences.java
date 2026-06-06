class Solution {
    public int[] leftRightDifference(int[] nums) {
        int ans[] = new int[nums.length];
        int ls[]= new int[nums.length];
        int rs[] = new int[nums.length];
        int i=0;
        while(i<nums.length){
            if(i==0){
                ls[i]=0;
                i++;
            }
            else{
                int j=i-1,s=0;
                while(j>=0){
                    s+=nums[j];
                    j--;
                }
                ls[i]=s;
                i++;
            }
        }
        i=nums.length-1;
        while(i>=0){
            if(i==nums.length-1){
                rs[i]=0;
                i--;
            }
            else{
                int j=i+1,s=0;
                while(j<nums.length){
                    s+=nums[j];
                    j++;
                }
                rs[i]=s;
                i--;
            }
        }
        for(int k=0; k<nums.length; k++){
            ans[k]= Math.abs(ls[k]-rs[k]);
        }
        return ans;
    }
}