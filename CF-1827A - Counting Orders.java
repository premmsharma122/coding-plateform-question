import java.util.*;

public class Main {
    static final long MOD = 1000000007;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();

            int[] a = new int[n];
            for(int i=0;i<n;i++) a[i] = sc.nextInt();
            Arrays.sort(a);

            Integer[] b = new Integer[n];
            for(int i=0;i<n;i++) b[i] = sc.nextInt();
            Arrays.sort(b, Collections.reverseOrder());

            long res = 1;

            for(int i=0;i<n;i++){
                int temp = upperBound(a, b[i]);
                long count = n - temp;
                res = res * Math.max(count - i, 0) % MOD;
            }

            System.out.println(res);
        }
    }

    static int upperBound(int[] arr, int val){
        int l = 0, r = arr.length;
        while(l < r){
            int m = (l + r) / 2;
            if(arr[m] <= val) l = m + 1;
            else r = m;
        }
        return l;
    }
}
