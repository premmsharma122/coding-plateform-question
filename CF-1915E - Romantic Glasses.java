import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            HashSet<Long> set = new HashSet<>();
            long prefix = 0;

            set.add(0L); // important

            boolean found = false;

            for (int i = 0; i < n; i++) {

                // transform on the fly
                if ((i + 1) % 2 == 0) {
                    prefix -= arr[i];
                } else {
                    prefix += arr[i];
                }

                if (set.contains(prefix)) {
                    found = true;
                    break;
                }

                set.add(prefix);
            }

            System.out.println(found ? "YES" : "NO");
        }
    }
}
