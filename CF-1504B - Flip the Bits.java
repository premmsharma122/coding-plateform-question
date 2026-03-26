import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();

            int zero = 0, one = 0;
            boolean[] good = new boolean[n];

            // Step 1: mark valid prefixes
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '0') zero++;
                else one++;

                if (zero == one) good[i] = true;
            }

            int flip = 0;
            boolean possible = true;

            // Step 2: process from right to left
            for (int i = n - 1; i >= 0; i--) {
                char current;

                if (flip == 0) current = a.charAt(i);
                else current = (a.charAt(i) == '0') ? '1' : '0';

                if (current != b.charAt(i)) {
                    if (!good[i]) {
                        possible = false;
                        break;
                    }
                    flip ^= 1;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }
    }
}
