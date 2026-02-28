import java.util.*;

public class Main {

    static class Monster {
        int rem;
        int idx;

        Monster(int rem, int idx) {
            this.rem = rem;
            this.idx = idx;
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            long k = sc.nextLong();

            ArrayList<Monster> list = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                long a = sc.nextLong();

                long r = a % k;
                if (r == 0) r = k;

                list.add(new Monster((int) r, i));
            }

            Collections.sort(list, (x, y) -> {
                if (y.rem != x.rem)
                    return y.rem - x.rem;
                return x.idx - y.idx;    
            });

            for (Monster m : list)
                System.out.print(m.idx + " ");

            System.out.println();
        }
    }
}
