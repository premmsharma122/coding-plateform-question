import java.util.*;

public class Main{

    public static void help(Scanner sc){

        int n = sc.nextInt();

        long arr[] = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }

        long pre[] = new long[n];

        pre[0] = arr[0];

        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + arr[i];
        }

        long ans = 0;

        for(int k=1;k<=n;k++){

            if(n%k != 0) continue;

            int st = k-1;

            long min = pre[k-1];
            long max = pre[k-1];

            for(int i=st+k;i<n;i+=k){

                long cur = pre[i] - pre[i-k];

                min = Math.min(min,cur);
                max = Math.max(max,cur);
            }

            ans = Math.max(ans,Math.abs(max-min));
        }

        System.out.println(ans);
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0){
            help(sc);
        }
    }
}
