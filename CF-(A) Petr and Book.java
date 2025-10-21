import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        int arr[] = new int[7];
        for(int i=0; i<=6; i++){
            arr[i] = s.nextInt();
        }
        int curr=0;
        int ans=0;
        while(curr<n){
            for(int i=0; i<7; i++){
                curr+=arr[i];
                if(curr>=n){
                    ans =i+1;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
