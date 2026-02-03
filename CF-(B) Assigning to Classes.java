import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n = s.nextInt(); 
            int arr[] = new int[2*n];
            for(int i=0; i<2*n; i++){
                arr[i]  = s.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(Math.abs(arr[n]-arr[n-1]));
        }
    }
}
