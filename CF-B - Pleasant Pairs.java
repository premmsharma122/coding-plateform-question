import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            // value → index mapping
            int[] pos = new int[2 * n + 1];
            for (int i = 1; i <= n; i++) {
                pos[a[i]] = i;
            }

            int count = 0;

        
            for (int x = 1; x <= 2 * n; x++) {
                for (int y = 1; x * y <= 2 * n; y++) {

                    if (pos[x] == 0 || pos[y] == 0) continue;

                    int i = pos[x];
                    int j = pos[y];

                    if (i < j && x * y == i + j) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
