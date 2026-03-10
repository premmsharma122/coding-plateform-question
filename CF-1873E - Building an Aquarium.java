import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            long x = sc.nextLong();

            int arr[] = new int[n];
            int max = 0;

            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
            }

            long l = 1, r = max + x;
            long ans = 1;

            while(l <= r){
                long mid = (l + r) / 2;

                long water = 0;
                for(int j=0;j<n;j++){
                    if(arr[j] < mid)
                        water += (mid - arr[j]);
                    
                    if(water > x) break;
                }

                if(water <= x){
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(ans);
        }
    }
}
