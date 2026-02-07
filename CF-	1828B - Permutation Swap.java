import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            int g = 0;

            for (int i = 0; i < n; i++) {
                int diff = Math.abs(p[i] - (i + 1));
                g = gcd(g, diff);
            }

            System.out.println(g);
        }
    }
}
