import java.util.*;
 
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();
 
            int max = Math.max(a, Math.max(b, c));
 
            
            while (n > 0) {
                if (a < max) {
                    int need = max - a;
                    if (n >= need) {
                        n -= need;
                        a = max;
                    } else {
                        a += n;
                        n = 0;
                    }
                } else if (b < max) {
                    int need = max - b;
                    if (n >= need) {
                        n -= need;
                        b = max;
                    } else {
                        b += n;
                        n = 0;
                    }
                } else if (c < max) {
                    int need = max - c;
                    if (n >= need) {
                        n -= need;
                        c = max;
                    } else {
                        c += n;
                        n = 0;
                    }
                } else {
                    break; 
                }
            }
 
            
            if (a == b && b == c && n % 3 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
