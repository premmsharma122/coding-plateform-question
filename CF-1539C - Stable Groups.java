import java.util.*;

public class StableGroups {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong(); // Number of initial students
		long k = scanner.nextLong(); // Number of additional students that can be invited
		long x = scanner.nextLong(); // Maximum allowed level difference for a stable group

		// List to store the levels of the students
		List<Long> levels = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			levels.add(scanner.nextLong()); // Input the levels of the students
		}

		// Sort the levels to facilitate grouping
		Collections.sort(levels);

		// List to store the differences between consecutive levels that are greater than x
		List<Long> differences = new ArrayList<>();

		// Calculate the differences between consecutive levels
		for (int i = 0; i < n - 1; i++) {
			// If the difference is greater than x, store it
			if (levels.get(i + 1) - levels.get(i) > x) {
				differences.add(levels.get(i + 1) - levels.get(i));
			}
		}

		// Sort the differences to process the smallest gaps first
		Collections.sort(differences);

		// Initial number of groups is the number of gaps + 1
		int ans = differences.size() + 1;

		// Try to reduce the number of groups by inviting additional students
		for (long difference : differences) {
			// Calculate the minimum number of students needed to fill the gap
			long val = (difference / x) + (difference % x != 0 ? 1 : 0) - 1; // ceil(difference / x) - 1

			// If we have enough students to fill the gap, reduce the number of groups
			if (k >= val) {
				ans--;
				k -= val;
			}
		}

		// Output the minimum number of stable groups
		System.out.println(ans);
	}
}

// Total Time Complexity (TC): O(N log N)
// Total Space Complexity (SC): O(N)
