import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){

            int n = sc.nextInt();
            int k = sc.nextInt();

            long arr[] = new long[n];

            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }

            Arrays.sort(arr);

            long pre[] = new long[n+1];

            for(int i=0;i<n;i++){
                pre[i+1] = pre[i] + arr[i];
            }

            long ans = 0;

            for(int i=0;i<=k;i++){

                int left = 2*i;
                int right = n - (k-i);

                if(left <= right){
                    long sum = pre[right] - pre[left];
                    ans = Math.max(ans, sum);
                }
            }

            System.out.println(ans);
        }
    }
}
