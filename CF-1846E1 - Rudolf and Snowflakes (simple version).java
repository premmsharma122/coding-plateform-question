import java.io.*;
import java.util.*;

public class SnowflakeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int MAXN = 1_000_000;
        boolean[] isPossible = new boolean[MAXN + 1];

        // Precompute possible snowflake vertex counts
        for (long i = 2; i <= 10000; i++) {  // i is the base
            long current = i * i * i;        // i^3
            long current1 = (current - 1) / (i - 1);

            while (current1 <= MAXN) {
                isPossible[(int) current1] = true;
                current *= i;
                current1 = (current - 1) / (i - 1);
            }
        }

        // Process test cases
        for (int q = 0; q < t; q++) {
            int n = Integer.parseInt(br.readLine());
            out.append(isPossible[n] ? "YES\n" : "NO\n");
        }

        System.out.print(out);
    }
}
// Time Complexity (TC): O(t + 10^4 * logn)
// Space Complexity (SC): O(n)
