import java.util.*;

public class Main {

    // function to calculate deletions for a chosen character
    static int solve(String s, char ch) {
        int i = 0, j = s.length() - 1;
        int count = 0;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (s.charAt(i) == ch) {
                i++;
                count++;
            } else if (s.charAt(j) == ch) {
                j--;
                count++;
            } else {
                return Integer.MAX_VALUE; // impossible
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int ans = Integer.MAX_VALUE;

            // try all possible characters
            for (char ch = 'a'; ch <= 'z'; ch++) {
                int res = solve(s, ch);
                ans = Math.min(ans, res);
            }

            if (ans == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }
    }
}
