import java.util.*;

public class DistrictsConnection {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); // Read the number of test cases

		while (t-- > 0) {
			int n = scanner.nextInt(); // Read the number of districts

			int[] gang = new int[n + 1]; // Array to store the gang each district belongs to
			for (int i = 1; i <= n; i++) {
				gang[i] = scanner.nextInt(); // Read the gang for each district
			}

			List<int[]> edges = new ArrayList<>(); // List to store the edges (roads) between districts

			int val1 = 1, val2 = -1; // Initialize the first two nodes to be connected by an edge
			for (int i = 2; i <= n; i++) {
				if (gang[i] != gang[1]) {
					edges.add(new int[]{1, i}); // Connect the first district with a different gang district
					val2 = i; // Store the index of the second district
					break;
				}
			}

			if (val2 == -1) {
				System.out.println("NO"); // If no different gang is found, output NO
				continue;
			}

			for (int i = 2; i <= n; i++) {
				if (i == val2) continue; // Skip the already connected district

				if (gang[i] != gang[val1]) {
					edges.add(new int[]{val1, i}); // Connect with the first district if gangs are different
				} else {
					edges.add(new int[]{val2, i}); // Otherwise, connect with the second district
				}
			}

			System.out.println("YES"); // Output YES if all districts can be connected

			for (int[] edge : edges) {
				System.out.println(edge[0] + " " + edge[1]); // Output each road
			}
		}
		scanner.close();
	}

	// Time Complexity (TC): O(N)
	// Space Complexity (SC): O(N)
}
