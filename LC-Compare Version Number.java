class Solution {
    public int compareVersion(String version1, String version2) {
        String a1[] = version1.split("\\.");
        String a2[] = version2.split("\\.");
        boolean c =true;
        int l=0, r=0;
        while(l<a1.length && r<a2.length){
            int numl = Integer.parseInt(a1[l]);
            int numr = Integer.parseInt(a2[r]);
            if(numl >  numr) return 1;
            if(numl < numr) return -1;
            l++;
            r++;

        }
        while(l<a1.length){
            if(Integer.parseInt(a1[l]) != 0) return  1;
            l++;
        }
        while(r<a2.length){
            if(Integer.parseInt(a2[r]) != 0) return -1;
            r++;
        }
        
        return 0;
    }
}
