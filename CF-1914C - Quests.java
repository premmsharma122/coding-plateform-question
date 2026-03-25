import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            int k =sc.nextInt();
            int a[] = new int[n];   
            int b[] = new int[n];
            for(int i=0; i<n; i++){
                a[i] =sc.nextInt();
            }
            for(int i=0; i<n; i++){
                b[i] =sc.nextInt();
            }
            int max=0,sum=0,ans=0;
            for(int i=0; i<Math.min(n,k); i++){
                sum+=a[i];
                max = Math.max(max,b[i]);
                ans=Math.max(ans,sum+(k-(i+1))*max);
            }
            System.out.println(ans);
        }
    }
}
