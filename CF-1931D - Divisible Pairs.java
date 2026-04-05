import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Map<String, Long> map = new HashMap<>();
            long count = 0;

            for (int i = 0; i < n; i++) {
                long rx = a[i] % x;
                long ry = a[i] % y;

                long need_rx = (x - rx) % x;

                String key = need_rx + "#" + ry;
                count += map.getOrDefault(key, 0L);

                String curr = rx + "#" + ry;
                map.put(curr, map.getOrDefault(curr, 0L) + 1);
            }

            System.out.println(count);
        }
    }
}
