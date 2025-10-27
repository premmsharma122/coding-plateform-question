import java.util.*;

public class Main {
    public static boolean help(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] a1 = s.toCharArray();s
        char[] a2 = t.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        for (int i = 0; i < s.length(); i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String p = sc.next();
            String h = sc.next();
            boolean found = false;

            for (int i = 0; i + p.length() <= h.length(); i++) {
                String ch = h.substring(i, i + p.length());
                if (help(ch, p)) {
                    System.out.println("YES");
                    found = true;
                    break;
                }
            }

            if (!found) System.out.println("NO");
        }
    }
}
