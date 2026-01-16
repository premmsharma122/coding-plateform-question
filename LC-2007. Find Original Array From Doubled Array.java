// class Solution {
//     public int[] findOriginalArray(int[] changed) {
//         // int mid = changed.length/2;
//         // int i=0, j=mid;
//         // while(i<mid && j<changed.length) {
//         //     if(changed[i]*2==changed[j]){
//         //         a[idx++] = changed[i];
//         //         i++;
//         //         j++;
//         //     }else {
//         //         j++;
//         //     }
//         // }
//         // int z[] = new int[mid];
//         // int checkz[] = new int[changed.length];
//         // if(Arrays.equals(checkz, changed)) return z;
//         // boolean f = true;
//         // for(int v : a){
//         //     if(v!=0) f= false;
//         // }
//         // if(f==false) return a;
//         // return new int[]{};
//         if(changed.length==1) return new int[]{};
//         Arrays.sort(changed);
//         HashMap<Integer, Integer> hm = new HashMap<>();
//         for(int i=0; i<changed.length; i++){
//             hm.put(changed[i],hm.getOrDefault(changed[i],0)+1);
//         }
//         int ans[] = new int[changed.length/2];
//         int idx=0;
//         for(int a : changed){
//             if(hm.get(a)==0) continue;

//             if(hm.getOrDefault(a*2,0)==0) return new int[]{};
//             hm.put(a,hm.get(a)-1);
//             hm.put(a*2, hm.get(a*2)-1);
//             ans[idx++] = a;
//         }
//         return ans;

//     }
// }
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[]{};

        Arrays.sort(changed);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : changed) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        int[] ans = new int[n / 2];
        int idx = 0;

        for (int x : changed) {
            if (hm.get(x) == 0) continue;

            // special zero handling
            if (x == 0) {
                if (hm.get(0) < 2) return new int[]{};
                hm.put(0, hm.get(0) - 2);
                ans[idx++] = 0;
            } else {
                if (hm.getOrDefault(2 * x, 0) == 0) return new int[]{};
                hm.put(x, hm.get(x) - 1);
                hm.put(2 * x, hm.get(2 * x) - 1);
                ans[idx++] = x;
            }
        }

        return ans;
    }
}
