import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            boolean ok = true;

            for (int i = 0; i < n / 2; i++) {
                int diff = Math.abs(s.charAt(i) - s.charAt(n - i - 1));
                if (diff != 0 && diff != 2) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}
