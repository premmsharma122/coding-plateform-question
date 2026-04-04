import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            List<Integer> gaps = new ArrayList<>();

            // normal gaps
            for (int i = 1; i < m; i++) {
                gaps.add(arr[i] - arr[i - 1] - 1);
            }

            // circular gap
            gaps.add((n - arr[m - 1]) + (arr[0] - 1));

            // sort descending
            Collections.sort(gaps, Collections.reverseOrder());

            int days = 0;
            int saved = 0;

            for (int gap : gaps) {
                int remaining = gap - 2 * days;

                if (remaining <= 0) continue;

                if (remaining == 1) {
                    saved += 1;
                    days += 1;
                } else {
                    saved += (remaining - 1);
                    days += 2;
                }
            }

            System.out.println(n - saved);
        }
    }
}
