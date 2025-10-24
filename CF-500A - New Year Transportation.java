import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        int m = s.nextInt();
        int arr[] = new int[n+1];
        for(int i=1; i<=n-1; i++){
            arr[i] =s.nextInt();
        }
        int idx=1;
        while(idx<m){
            idx = arr[idx]+idx;
            
        }
        if(idx==m){
            System.out.println("YES");
        }else System.out.println("NO");
        
    }
}
