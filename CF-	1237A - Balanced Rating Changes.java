import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        // 1. Initial calculation: b[i] = a[i] / 2 (truncates toward zero)
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i] / 2;
            sum += b[i];
        }

        // 2. Adjust sum to zero by choosing the other valid rounding for odd numbers.
        for (int i = 0; i < n && sum != 0; i++) {
            
            // Only adjust if the number is odd.
            if (a[i] % 2 != 0) { 
                
                // Case 1: Sum is too low (sum < 0). Need to increase B[i] by 1.
                // This is only a valid move for a POSITIVE odd number (floor -> ceil).
                if (sum < 0 && a[i] > 0) {
                    b[i]++;  // Adjust from floor (a[i]/2) to ceiling (a[i]/2 + 1)
                    sum++;
                } 
                
                // Case 2: Sum is too high (sum > 0). Need to decrease B[i] by 1.
                // This is only a valid move for a NEGATIVE odd number (ceil -> floor).
                else if (sum > 0 && a[i] < 0) {
                    b[i]--;  // Adjust from ceiling (a[i]/2) to floor (a[i]/2 - 1)
                    sum--;
                }
            }
        }

        // 3. Print result
        for (int i = 0; i < n; i++) {
            System.out.println(b[i]);
        }
        
        sc.close();
    }
}
