import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            List<Integer> mins = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

            for (int k = 0; k < n; k++) {

                int m = sc.nextInt();
                int arr[] = new int[m];

                for (int i = 0; i < m; i++)
                    arr[i] = sc.nextInt();

                Arrays.sort(arr);

                mins.add(arr[0]);
                second.add(arr[1]);
            }

            Collections.sort(mins);
            Collections.sort(second);

            long sum = 0;

            // add all second minimums
            for (int x : second)
                sum += x;

            // replace smallest second minimum
            sum -= second.get(0);

            // add smallest minimum
            sum += mins.get(0);

            System.out.println(sum);
        }
    }
}
