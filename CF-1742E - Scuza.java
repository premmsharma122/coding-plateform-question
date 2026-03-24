import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long pre[] = new long[n];
            int maxPref[] = new int[n];

            pre[0] = arr[0];
            maxPref[0] = arr[0];

            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + arr[i];
                maxPref[i] = Math.max(maxPref[i - 1], arr[i]);
            }

            while (q-- > 0) {
                int k = sc.nextInt();

                int l = 0, r = n - 1, pos = -1;

                while (l <= r) {
                    int mid = (l + r) / 2;

                    if (maxPref[mid] <= k) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }

                if (pos == -1) System.out.print(0 + " ");
                else System.out.print(pre[pos] + " ");
            }
            System.out.println();
        }
    }
}
