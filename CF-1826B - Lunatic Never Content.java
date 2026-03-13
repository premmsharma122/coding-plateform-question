import java.util.*;
public class Main{
    public static long help(long a, long b){
        while(b!=0){
            long t= b;
            b =a%b;
            a=t;
        }
        return a;
    }
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            long arr[] = new long[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextLong();
            }
            if(n==1){
                System.out.println(0);
            }else{
                long g = 0;
                for(int i=0; i<n/2; i++){
                    long dif = Math.abs(arr[i]-arr[n-i-1]);
                    g = help(g,dif);
                }
                System.out.println(g);
            }
        }
    }
}
