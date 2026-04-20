import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); // Number of test cases
		while (t-- > 0) {
			int n = scanner.nextInt(); // Number of caves
			List<int[]> a = new ArrayList<>(); // List to store the maximum armor needed and number of monsters for each cave
			for (int i = 0; i < n; i++) { // Loop over each cave
				int m = scanner.nextInt(); // Number of monsters in the current cave
				int[] v = new int[m]; // Array to store adjusted armor values for monsters in the current cave
				for (int j = 0; j < m; j++) { // Loop over each monster in the current cave
					int x = scanner.nextInt(); // Armor value of the current monster
					v[j] = x - j + 1; // Adjust the armor value by subtracting the index and adding 1
				}
				Arrays.sort(v); // Sort the adjusted armor values to find the maximum needed power for this cave
				a.add(new int[]{v[m - 1], m}); // Store the maximum adjusted armor value and the number of monsters in the list
			}
			a.sort(Comparator.comparingInt(o -> o[0])); // Sort the list of caves based on the maximum adjusted armor value
			int ans = a.get(0)[0]; // Initialize the answer with the first cave's maximum adjusted armor
			int increase = a.get(0)[1]; // Initialize the power increase with the number of monsters in the first cave
			for (int i = 1; i < n; i++) { // Loop over the remaining caves
				ans = Math.max(ans, a.get(i)[0] - increase); // Update the answer with the maximum of the current answer and the current cave's maximum adjusted armor minus the power increase
				increase += a.get(i)[1]; // Increase the power increase by the number of monsters in the current cave
			}
			System.out.println(ans); // Output the minimum starting power needed for the hero
		}
		scanner.close();
	}
}

// Time Complexity (TC): O(nlogn + k)
// Space Complexity (SC): O(n + k)
