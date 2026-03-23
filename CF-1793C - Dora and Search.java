import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int l = 0, r = n - 1;
            int minVal = 1, maxVal = n;

            while (l < r) {
                if (a[l] == minVal) {
                    l++;
                    minVal++;
                } else if (a[l] == maxVal) {
                    l++;
                    maxVal--;
                } else if (a[r] == minVal) {
                    r--;
                    minVal++;
                } else if (a[r] == maxVal) {
                    r--;
                    maxVal--;
                } else {
                    System.out.println((l + 1) + " " + (r + 1));
                    break;
                }
            }

            if (l >= r) {
                System.out.println(-1);
            }
        }
    }
}
