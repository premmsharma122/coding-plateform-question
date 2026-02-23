import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            int arr[] = new int[n];
            long c0=0,c1=0;
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
                if(arr[i]==1) c1++;
                else if(arr[i]==0) c0++;
            }
            long c =c1*(long)Math.pow(2,c0);
            System.out.println(c);
            
        }
    }
}
