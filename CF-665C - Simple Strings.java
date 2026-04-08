import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char[] arr = s.toCharArray();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {

                // try all characters
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    if (ch != arr[i - 1] && (i + 1 >= arr.length || ch != arr[i + 1])) {
                        arr[i] = ch;
                        break;
                    }
                }
            }
        }

        System.out.println(new String(arr));
    }
}
