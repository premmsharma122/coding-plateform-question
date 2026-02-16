import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        long t = sc.nextLong();
        while(t-->0){
            long n=sc.nextLong();
            long arr[] = new long[(int)n];
            for(int i=0; i<n; i++){
                arr[i]=sc.nextLong();
            }
            HashMap<Long, Long> hm = new HashMap<>();
            for(long a : arr){
                hm.put(a,hm.getOrDefault(a,0L)+1);
            }
            long mx=0;
            for(long v : hm.keySet()){
                mx = Math.max(mx, hm.get(v));
            }
            int op=0;
            while(mx< n){
                op++;
                if(mx*2<=n){
                    op+=mx;
                    mx*=2;
                }else{
                    op+=n-mx;
                    mx=n;
                }
            }
            System.out.println(op);
        }
    }
}
