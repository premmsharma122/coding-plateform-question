import java.util.*;
 
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            int s = sc.nextInt();
 
            int[] arr = new int[n];
            int total = 0;
 
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                total += arr[i];
            }
 
            
            if (total < s) {
                System.out.println(-1);
                continue;
            }
 
           
            int left = 0, sum = 0, maxLen = 0;
 
            for (int right = 0; right < n; right++) {
                sum += arr[right];
 
                while (sum > s) {
                    sum -= arr[left];
                    left++;
                }
 
                if (sum == s) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
 
            // operations = remove elements
            System.out.println(n - maxLen);
        }
    }
}
