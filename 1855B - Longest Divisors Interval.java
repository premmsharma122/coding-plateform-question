import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Fast I/O setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        String firstLine = br.readLine();
        if (firstLine == null) return;
        
        int t = Integer.parseInt(firstLine.trim());
        
        while (t-- > 0) {
            String nLine = br.readLine();
            if (nLine == null) break;
            long n = Long.parseLong(nLine.trim());
            
            long ans = 0;
            // Check consecutive divisors starting from 1
            // The loop will break very quickly (max ~42 iterations)
            for (long i = 1; i <= 100; i++) {
                if (n % i == 0) {
                    ans = i;
                } else {
                    break;
                }
            }
            out.println(ans);
        }
        out.flush();
        out.close();
    }
}
