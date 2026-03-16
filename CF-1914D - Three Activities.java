import java.util.*;
 
public class Main{
 
    static class Pair{
        int val;
        int idx;
 
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
 
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while(t-- > 0){
 
            int n = sc.nextInt();
 
            Pair arr1[] = new Pair[n];
            Pair arr2[] = new Pair[n];
            Pair arr3[] = new Pair[n];
 
            HashSet<Integer> hs = new HashSet<>();
 
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                arr1[i] = new Pair(a,i);
            }
 
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                arr2[i] = new Pair(a,i);
            }
 
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                arr3[i] = new Pair(a,i);
            }
 
            Arrays.sort(arr1,(a,b)->b.val-a.val);
            Arrays.sort(arr2,(a,b)->b.val-a.val);
            Arrays.sort(arr3,(a,b)->b.val-a.val);
 
            int ans = 0;
 
            hs.add(arr1[0].idx);
            ans += arr1[0].val;
 
            for(int i=0;i<n;i++){
                int v = arr2[i].val;
                int id = arr2[i].idx;
 
                if(!hs.contains(id)){
                    ans += v;
                    hs.add(id);
                    break;
                }
            }
 
            for(int i=0;i<n;i++){
                int v = arr3[i].val;
                int id = arr3[i].idx;
 
                if(!hs.contains(id)){
                    ans += v;
                    break;
                }
            }
 
            System.out.println(ans);
        }
    }
}
