class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int m=1;
        if(arr[0]!=0){
            arr[0]=1;
        }
        for(int i=1; i<arr.length; i++){
            
                if(Math.abs(arr[i]-arr[i-1])>1){
                    arr[i]=arr[i-1]+1;
                    m = Math.max(m,Math.max(arr[i],arr[i-1]));
                }else{
                    m = Math.max(m,Math.max(arr[i],arr[i-1]));
                }
            
            
        }
        return m;
    }
}