import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            long c = sc.nextLong();

            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            long low = 1, high = 1000000000L;

            while (low <= high) {

                long mid = (low + high) / 2;

                long sum = 0;

                for (int i = 0; i < n; i++) {
                    long side = arr[i] + 2 * mid;
                    sum += side * side;
                    if (sum > c) break;
                }

                if (sum == c) {
                    System.out.println(mid);
                    break;
                } 
                else if (sum < c) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
        }
    }
}
