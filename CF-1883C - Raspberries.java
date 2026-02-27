import java.util.*;

public class Raspberries {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long t = scanner.nextLong(); // Read the number of test cases
		while (t-- > 0) {
			long n = scanner.nextLong(); // Read the size of the array
			long k = scanner.nextLong(); // Read the divisor k
			long[] a = new long[(int) n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextLong(); // Read the array elements
			}

			long ans = Integer.MAX_VALUE; // Initialize the minimum operations to a large value
			long evenCount = 0; // Count of even numbers in the array
			for (int i = 0; i < n; i++) {
				if (a[i] % 2 == 0) {
					evenCount++; // Increment evenCount if the element is even
				}
				if (a[i] % k == 0) {
					ans = 0; // If any element is divisible by k, no operations are needed
				}
				ans = Math.min(ans, (k - a[i] % k)); // Calculate the minimum operations needed
			}

			// Special handling for k = 4
			if (k == 4) {
				if (evenCount >= 2) {
					ans = Math.min(ans, 0L); // If there are at least two even numbers, no operations are needed
				} else if (evenCount == 1) {
					ans = Math.min(ans, 1L); // If there is one even number, one operation is needed
				} else if (evenCount == 0) {
					ans = Math.min(ans, 2L); // If there are no even numbers, two operations are needed
				}
			}
			System.out.println(ans); // Output the minimum number of operations
		}
		scanner.close();
	}
}

// Time Complexity (TC): O(n) = O(2*10^5)
// Space Complexity (SC): O(n) = O(2*10^5)
