class Solution {
    static boolean help(int arr[], int trg, int idx){
        if(trg == 0) return true;
        if(idx == arr.length || trg < 0) return false;
        return help(arr,trg-arr[idx],idx+1) || help(arr,trg,idx+1);
    }
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        for(int n : arr){
            sum += n;
        }
        int trg = sum/2;
        if(sum % 2 !=0) return false;
        return help(arr,trg, 0);
    }
}
