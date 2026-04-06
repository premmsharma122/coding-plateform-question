import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); // Read the number of test cases
		while (t-- > 0) {
			int n = scanner.nextInt(); // Read the number of elements in the array
			int[] a = new int[n]; // Initialize an array to store the elements
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt(); // Read the elements of the array
			}

			Map<Integer, Integer> mp = new HashMap<>(); // Map to store prime factors and their counts
			for (int i = 0; i < n; i++) { // Iterate over each element in the array
				for (int j = 2; j * j <= a[i]; j++) { // Check for prime factors up to the square root of a[i]
					while (a[i] % j == 0) { // While j is a factor of a[i]
						mp.put(j, mp.getOrDefault(j, 0) + 1); // Increment the count of the prime factor j
						a[i] /= j; // Divide a[i] by j to reduce it
					}
				}
				// If a[i] is greater than 1, it is a prime factor itself
				if (a[i] > 1) {
					mp.put(a[i], mp.getOrDefault(a[i], 0) + 1);
				}
			}

			boolean flag = true; // Flag to check if all prime factor counts are divisible by n
			for (Map.Entry<Integer, Integer> entry : mp.entrySet()) { // Iterate over the map of prime factors
				if (entry.getValue() % n != 0) { // If any prime factor count is not divisible by n
					flag = false; // Set flag to false indicating not possible to equalize
					break;
				}
			}

			if (flag) {
				System.out.println("YES"); // If flag is true, output YES
			} else {
				System.out.println("NO"); // Otherwise, output NO
			}
		}
		scanner.close();
	}
}

// Time Complexity (TC): O(n*root(a[i]))
// Space Complexity (SC): O(n)
