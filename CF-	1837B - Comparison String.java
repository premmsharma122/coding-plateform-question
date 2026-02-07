import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int maxLen = 1;
            int curr = 1;

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    curr++;
                    maxLen = Math.max(maxLen, curr);
                } else {
                    curr = 1;
                }
            }

            System.out.println(maxLen + 1);
        }
    }
}
