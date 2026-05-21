class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            int n = arr1[i];
            hs.add(n);
            while(n>0){
                hs.add(n);
                n = n/10;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<arr2.length; i++){
            int n =arr2[i];
            if(hs.contains(n)) res.add(n);
            while(n>0){
                if(hs.contains(n)) res.add(n);
                n=n/10;
            }
        }
        int max =0;
        for(int a : res){
            String s = String.valueOf(a);
            max = Math.max(max,s.length());
        }
        return max;
    }
}