import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            char c = sc.next().charAt(0);
            String s = sc.next();

            boolean allEqual = true;
            for (char ch : s.toCharArray()) {
                if (ch != c) {
                    allEqual = false;
                    break;
                }
            }

            if (allEqual) {
                System.out.println(0);
                continue;
            }

            // Try 1 operation
            for (int x = 1; x <= n; x++) {
                boolean ok = true;

                for (int i = x; i <= n; i += x) {
                    if (s.charAt(i - 1) != c) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    System.out.println(1);
                    System.out.println(x);
                    break;
                }

                // If no x works → 2 operations
                if (x == n) {
                    System.out.println(2);
                    System.out.println(n + " " + (n - 1));
                }
            }
        }
    }
}
