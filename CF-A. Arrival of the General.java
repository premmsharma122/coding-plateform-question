import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
 
        int max = -1, maxIndex = -1;
        int min = 101, minIndex = -1;
 
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
 
        
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
 
        int moves = maxIndex + (n - 1 - minIndex);
        if (maxIndex > minIndex) moves--; // adjust if overlap
        System.out.println(moves);
    }
}
