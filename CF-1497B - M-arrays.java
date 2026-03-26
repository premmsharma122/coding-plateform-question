import java.util.*;

public class MArrays {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); // Read the number of test cases

		while (t-- > 0) {
			int n = scanner.nextInt(); // Read n (number of elements)
			int m = scanner.nextInt(); // Read m (divisor)

			int[] v = new int[n];
			for (int i = 0; i < n; i++) {
				v[i] = scanner.nextInt(); // Read the array elements
			}

			int[] rem = new int[m]; // Initialize an array to count remainders

			// Count the frequency of each remainder when elements are divided by m
			for (int i = 0; i < n; i++) {
				rem[v[i] % m]++;
			}

			int ans = 0; // Initialize the answer to store the number of m-divisible arrays

			// Iterate over each possible remainder
			for (int i = 0; i < m; i++) {
				int x = rem[i];
				int y = rem[(m - i) % m];

				// If both remainders are zero, continue to the next
				if (x == 0 && y == 0) {
					continue;
				}

				// Calculate the minimum of the two counts
				int tmp = Math.min(x, y);

				// Adjust the counts by removing pairs
				x -= Math.min(tmp + 1, x);
				y -= Math.min(tmp + 1, y);

				// Increment the answer for each pair
				ans++;

				// Add the remaining elements to the answer
				ans += (x + y);

				// Reset the counts for these remainders
				rem[i] = 0;
				rem[(m - i) % m] = 0;
			}

			System.out.println(ans); // Output the result for the current test case
		}

		scanner.close();
	}
}

// Time Complexity (TC): O(n + m)
// Space Complexity (SC): O(n + m)
