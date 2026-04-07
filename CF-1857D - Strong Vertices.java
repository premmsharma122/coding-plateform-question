import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            int a[] = new int[n];
            for(int i=0; i<n; i++) a[i]=sc.nextInt();
            int mx= Integer.MIN_VALUE;
            int b[] = new int[n];
            ArrayList<Integer> ans= new ArrayList<>();
            int val[] = new int[n];
            for(int i=0; i<n; i++){
                b[i] = sc.nextInt();
                val[i] = a[i]-b[i];
                mx = Math.max(mx,val[i]);
            }
            for(int i=0; i<val.length; i++){
                if(val[i]==mx) ans.add(i+1);
            }
            System.out.println(ans.size());
            for(int i : ans) System.out.print(i+" ");
        }
    }
    
}
