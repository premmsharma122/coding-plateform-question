import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt(); 

            int[] p = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                p[i] = i;
            }

            p[r] = p[l - 1];

            int offset = 1 << 19;
            for (int i = r + 1; i <= n; i++) {
                p[i] = i + offset;
            }

            for (int i = 1; i <= n; i++) {
                sb.append(p[i] ^ p[i - 1]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
