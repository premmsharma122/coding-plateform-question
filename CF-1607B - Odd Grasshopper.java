import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long x = sc.nextLong();
            long n = sc.nextLong();
            
            long r = n % 4;
            
            if (r == 1) {
                if (x % 2 == 0) x -= n;
                else x += n;
            } 
            else if (r == 2) {
                if (x % 2 == 0) x += 1;
                else x -= 1;
            } 
            else if (r == 3) {
                if (x % 2 == 0) x += n + 1;
                else x -= n + 1;
            }
            
            System.out.println(x);
        }
        
        sc.close();
    }
}
