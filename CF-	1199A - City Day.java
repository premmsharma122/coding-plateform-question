import java.util.*;
public class Main {
    public static boolean help(int arr[], int x, int y, int i) {
        
        for (int j = i - x; j < i; j++) {
            if (j >= 0 && arr[i] >= arr[j]) return false;
        }
       
        for (int k = i + 1; k <= i + y && k < arr.length; k++) {
            if (arr[i] >= arr[k]) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (help(arr, x, y, i)) {
                System.out.println(i + 1); 
                return;
            }
        }
    }
}
