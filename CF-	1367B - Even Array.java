import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t =s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = s.nextInt();
            }
            int ev=0;
            int od=0;
            for(int i=0; i<n; i++){
                if(i%2 != arr[i]%2){
                    if(i%2 !=0) ev++;
                    else od++;
                }
            }
            if(ev != od) System.out.println(-1);
            else System.out.println(ev);
        }
    }
}
