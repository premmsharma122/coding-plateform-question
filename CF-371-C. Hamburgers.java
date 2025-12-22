import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String recipe = sc.next();
        long nb = sc.nextLong();
        long ns = sc.nextLong();
        long nc = sc.nextLong();
        long pb = sc.nextLong();
        long ps = sc.nextLong();
        long pc = sc.nextLong();
        long r  = sc.nextLong();

        // Count ingredients in one hamburger
        long cb = 0, cs = 0, cc = 0;
        for (char ch : recipe.toCharArray()) {
            if (ch == 'B') cb++;
            else if (ch == 'S') cs++;
            else cc++;
        }

        long low = 0, high = (long)1e13, ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            long needB = Math.max(0, mid * cb - nb);
            long needS = Math.max(0, mid * cs - ns);
            long needC = Math.max(0, mid * cc - nc);

            long cost = needB * pb + needS * ps + needC * pc;

            if (cost <= r) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
