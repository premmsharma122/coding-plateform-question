import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            int k =sc.nextInt();
            int arr[] = new int[n];
            int b[] = new int[32];
            int ans = (1<<31)-1;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                ans &=arr[i];
                for(int j=0; j<32; j++){
                    if((arr[i] & (1<<j))!=0){
                        b[j]++;
                    }
                }
            }
            for(int i=30; i>=0; i--){
                if(k>=n-b[i]){
                    ans |= (1 << i); 
					k -= (n - b[i]);
                }
            }
            System.out.println(ans);
        }
    }
}
