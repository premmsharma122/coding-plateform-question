import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++) {
                arr[i]=sc.nextInt();
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0; i<n; i++){
                int l=1, r=i+1;
                while(l<=r){
                    int m =(l+r)/2;
                    if(arr[i-m+1]>=m){
                        l=m+1;
                    }else{
                        r=m-1;
                    }
                }
                ans.add(r);
            }
            for(int a : ans){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
