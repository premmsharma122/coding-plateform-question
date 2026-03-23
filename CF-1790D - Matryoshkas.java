import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            int prev = 0, ans = 0;
            int last = -1;

            for (int key : map.keySet()) {
                int cur = map.get(key);

                if (last != -1 && key != last + 1) {
                    prev = 0;
                }

                if (cur > prev) {
                    ans += (cur - prev);
                }

                prev = cur;
                last = key;
            }

            System.out.println(ans);
        }
    }
}
