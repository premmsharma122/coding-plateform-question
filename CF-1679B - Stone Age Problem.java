import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        int[] lastUpdateTime = new int[n];
        int currentTime = 1;
        int lastGlobalTime = 0;

        int globalValue = 0;

        while (q-- > 0) {
            int t = sc.nextInt();

            if (t == 1) {
                int i = sc.nextInt() - 1;
                int x = sc.nextInt();

                int old;

                if (lastUpdateTime[i] < lastGlobalTime) {
                    old = globalValue;
                } else {
                    old = arr[i];
                }

                totalSum = totalSum - old + x;

                arr[i] = x;
                lastUpdateTime[i] = currentTime;

                System.out.println(totalSum);

            } else {
                int x = sc.nextInt();

                totalSum = (long) x * n;
                globalValue = x;
                lastGlobalTime = currentTime;

                System.out.println(totalSum);
            }

            currentTime++;
        }
    }
}
