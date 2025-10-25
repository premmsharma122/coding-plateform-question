import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // ← FIXED (int instead of long)
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        long last = arr[n - 1];
        long tot = last;
        for (int i = n - 2; i >= 0; i--) {
            long nxt = Math.min(last - 1, arr[i]);
            if (nxt < 0) nxt = 0;
            last = nxt;
            tot += nxt;
        }
        System.out.println(tot);
    }
}
