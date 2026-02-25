import java.util.*;
 
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while(t-- > 0){
 
            int n = sc.nextInt();
            int x = sc.nextInt();
 
            int arr[] = new int[n];
 
            long tot = 0;  
            long sum = 0;
 
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                tot += arr[i];
                sum += (arr[i] + x - 1) / x;
            }
 
            long mx = sum;
            long min = (tot + x - 1) / x;
 
            System.out.println(min + " " + mx);
        }
    }
}
