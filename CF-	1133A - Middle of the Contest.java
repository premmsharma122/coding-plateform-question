import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String t1 = sc.next(); 
        String t2 = sc.next(); 

        
        String[] p1 = t1.split(":");
        String[] p2 = t2.split(":");

        int h1 = Integer.parseInt(p1[0]);
        int m1 = Integer.parseInt(p1[1]);
        int h2 = Integer.parseInt(p2[0]);
        int m2 = Integer.parseInt(p2[1]);

        
        int start = h1 * 60 + m1;
        int end = h2 * 60 + m2;

        
        int mid = (start + end) / 2;
        int h3 = mid / 60;
        int m3 = mid % 60;

        
        System.out.printf("%02d:%02d\n", h3, m3);
    }
}
