import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            
            int[] nextDiff = new int[n];
            nextDiff[n - 1] = -1;

            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] != arr[i + 1]) {
                    nextDiff[i] = i + 1;
                } else {
                    nextDiff[i] = nextDiff[i + 1];
                }
            }

            int q = sc.nextInt();

            while (q-- > 0) {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;

                if (nextDiff[l] != -1 && nextDiff[l] <= r) {
                    System.out.println((l + 1) + " " + (nextDiff[l] + 1));
                } else {
                    System.out.println("-1 -1");
                }
            }

            System.out.println(); 
        }

        
    }
}
