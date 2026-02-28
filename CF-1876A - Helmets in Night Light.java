import java.util.*;

public class Main {
    static class Person {
        int a, b;
        Person(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            long p = sc.nextLong();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();

            Person[] arr = new Person[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Person(a[i], b[i]);
            }

            // sort by sharing cost
            Arrays.sort(arr, (x, y) -> x.b - y.b);

            long cost = 0;

            // first person must be informed directly
            cost += p;
            long informed = 1;

            for (int i = 0; i < n && informed < n; i++) {

                // if sharing cost >= direct cost, stop using sharing
                if (arr[i].b >= p) break;

                // how many people this resident can inform
                long canShare = Math.min(arr[i].a, n - informed);

                cost += canShare * arr[i].b;
                informed += canShare;
            }

            // remaining people informed directly
            if (informed < n) {
                cost += (n - informed) * p;
            }

            System.out.println(cost);
        }
    }
}
