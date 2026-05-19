import java.util.*;

class codechef {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int n = s.length();

        long[] left = new long[n];
        long[] right = new long[n];

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1];
            if (s.charAt(i) == 'v' && s.charAt(i - 1) == 'v') {
                left[i]++;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1];
            if (s.charAt(i) == 'v' && s.charAt(i + 1) == 'v') {
                right[i]++;
            }
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'o') {
                ans += left[i] * right[i];
            }
        }

        System.out.println(ans);
    }
}
