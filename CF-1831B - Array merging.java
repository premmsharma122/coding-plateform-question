import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
 
            int[] a = new int[n];
            int[] b = new int[n];
 
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();
 
            int maxVal = 2 * n + 5;
 
            int[] bestA = new int[maxVal];
            int[] bestB = new int[maxVal];
 
            // longest streak in a
            for (int i = 0; i < n;) {
                int j = i;
                while (j < n && a[j] == a[i]) j++;
                bestA[a[i]] = Math.max(bestA[a[i]], j - i);
                i = j;
            }
 
         
            for (int i = 0; i < n;) {
                int j = i;
                while (j < n && b[j] == b[i]) j++;
                bestB[b[i]] = Math.max(bestB[b[i]], j - i);
                i = j;
            }
 
            int ans = 0;
            for (int v = 1; v < maxVal; v++) {
                ans = Math.max(ans, bestA[v] + bestB[v]);
            }
 
            System.out.println(ans);
        }
    }
}
