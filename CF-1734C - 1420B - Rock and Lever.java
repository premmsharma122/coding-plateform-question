import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int count[] = new int[32]; // for bits 0 to 31

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();

                int msb = 31 - Integer.numberOfLeadingZeros(x);
                count[msb]++;
            }

            long ans = 0;

            for (int i = 0; i < 32; i++) {
                long c = count[i];
                ans += c * (c - 1) / 2;
            }

            System.out.println(ans);
        }
    }
}
