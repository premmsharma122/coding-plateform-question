import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        int t = Integer.parseInt(st.nextToken());
 
        while (t-- > 0) {
            String line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
 
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
 
            // --- OPTIMIZATION: AVOID O(N^2) WORST CASE ---
            shuffle(a); 
            Arrays.sort(a);
            // ---------------------------------------------
 
            long totalPacks = 0;
            long currentPrefixSum = 0;
 
            for (int k = 0; k < n; k++) {
                currentPrefixSum += a[k];
 
                if (currentPrefixSum <= x) {
                    // Calculate days until this set of k+1 shops becomes too expensive
                    long extraDays = (x - currentPrefixSum) / (k + 1);
                    totalPacks += (extraDays + 1);
                } else {
                    break;
                }
            }
            sb.append(totalPacks).append("\n");
        }
        System.out.print(sb);
    }
 
    // Fisher-Yates shuffle to prevent Quicksort's worst case
    static void shuffle(long[] a) {
        Random rnd = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            long temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }
}
