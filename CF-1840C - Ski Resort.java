import java.util.Scanner;
 
public class SkiResort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long t = scanner.nextLong(); // Read the number of test cases
		while (t-- > 0) {
			long n = scanner.nextLong(); // Number of days
			long k = scanner.nextLong(); // Minimum days for vacation
			long q = scanner.nextLong(); // Max comfortable temperature
			long[] a = new long[(int) n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextLong(); // Read the temperature for each day
				// Mark the day as 1 if temperature is <= q, otherwise 0
				a[i] = (a[i] > q) ? 0 : 1;
			}
 
			long count_of_1s = 0; // To count consecutive days with temperature <= q
			long ways = 0; // To store the number of valid vacation periods
			for (int i = 0; i < n; i++) {
				if (a[i] == 1) {
					count_of_1s++; // Increment count if the day is valid
				} else {
					// If a sequence of valid days ends, calculate possible vacation periods
					if (count_of_1s >= k) {
						long diff = count_of_1s - k + 1;
						ways += (diff * (diff + 1)) / 2; // Add the number of ways for this sequence
					}
					count_of_1s = 0; // Reset the count for the next sequence
				}
			}
			// Check for any remaining sequence at the end of the array
			if (count_of_1s >= k) {
				long diff = count_of_1s - k + 1;
				ways += (diff * (diff + 1)) / 2;
			}
 
			System.out.println(ways); // Output the number of ways for this test case
		}
 
	}
}
 
 
