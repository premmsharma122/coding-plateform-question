import java.util.*;
public class Main{
    public static int help(int n, int m){
        if(n > m) return -1;      // impossible
        if(n == m) return 0;      // reached target

        int res2 = help(n * 2, m);
        int res3 = help(n * 3, m);

        if(res2 == -1 && res3 == -1) return -1; // both impossible
        if(res2 == -1) return 1 + res3;        // only multiply by 3 works
        if(res3 == -1) return 1 + res2;        // only multiply by 2 works
        return 1 + Math.min(res2, res3);       // take the minimum moves
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        System.out.println(help(n, m));
    }
}
>>>>>>>>>>>>> w/o Recursion <<<<<<<<<<<<<<<<
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long m = s.nextLong();

        if (m % n != 0) {
            System.out.println(-1);
            return;
        }

        long x = m / n;
        int count = 0;

        while (x % 2 == 0) {
            x /= 2;
            count++;
        }

        while (x % 3 == 0) {
            x /= 3;
            count++;
        }

        if (x != 1) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}

