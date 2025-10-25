import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        s.close();

        boolean allup = true;
        for (char c : str.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                allup = false;
                break;
            }
        }

        if (allup) {
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                sb.append(Character.toLowerCase(c));
            }
            System.out.println(sb);
            return;
        }

        char first = str.charAt(0);
        boolean restUpper = true;
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isUpperCase(str.charAt(i))) {
                restUpper = false;
                break;
            }
        }

        if (Character.isLowerCase(first) && restUpper) {
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(first));
            for (int i = 1; i < str.length(); i++) {
                sb.append(Character.toLowerCase(str.charAt(i)));
            }
            System.out.println(sb);
        } else {
            System.out.println(str);
        }
    }
}
