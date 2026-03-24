import java.util.*;

public class pr {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();

            HashSet<Integer> ts = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '1') {
                    ts.add(i + 1);
                }
            }

            boolean deleted[] = new boolean[n + 1]; // 🔥 FIX: track deleted

            long c = 0; // 🔥 FIX: use long

            for (int i = 1; i <= n; i++) {

                if (ts.contains(i)) continue; // skip if already in T

                for (int j = i; j <= n; j += i) {

                    if (ts.contains(j)) break; // 🔥 FIX: STOP at '1'

                    if (!deleted[j]) { // 🔥 FIX: avoid double counting
                        c += i;
                        deleted[j] = true;
                    }
                }
            }

            System.out.println(c);
        }
    }
}
