import java.util.*;

public class Teleporters {
	// Function to solve each test case
	private static void solve(Scanner scanner) {
		long n = scanner.nextLong(); // Number of teleporters
		long c = scanner.nextLong(); // Number of coins available
		List<Long> cost = new ArrayList<>(); // List to store the effective cost of using each teleporter

		// Read the cost of each teleporter and calculate the effective cost
		for (int i = 1; i <= n; i++) { // Loop through each teleporter
			long x = scanner.nextLong(); // Cost to use teleporter at position i
			cost.add(i + x); // Effective cost includes moving to position i
		}

		// Sort the costs in ascending order to use the cheapest teleporters first
		Collections.sort(cost);

		int i = 0; // Index to iterate through the sorted costs
		int ans = 0; // Counter for the number of teleporters used

		// Use teleporters while there are enough coins
		while (i < n && cost.get(i) <= c) {
			c -= cost.get(i); // Deduct the cost from the available coins
			ans++; // Increment the count of teleporters used
			i++; // Move to the next teleporter
		}

		System.out.println(ans); // Output the maximum number of teleporters used
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); // Number of test cases
		while (t-- > 0) {
			solve(scanner); // Solve each test case
		}
		scanner.close();
	}

	// Time Complexity (TC): O(nlogn)
	// Space Complexity (SC): O(n)
}
