import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            int k =sc.nextInt();
            if(n%2==0){
                int ans = (k-1)%n+1;
                System.out.println(ans);
                
            }else if(n%2!=0){
                int s = (k-1)/(n/2);
                int ans = (k+s-1)%n+1;
                System.out.println(ans);
                
            }
        }
    }
