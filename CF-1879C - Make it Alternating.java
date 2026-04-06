import java.util.*;

public class Main {

    static final int MOD = 998244353;

    static long fact(int n) {
        long res = 1;
        for(int i = 1; i <= n; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            String s = sc.next();

            int n = s.length();
            int deletions = 0;
            long ways = 1;

            int i = 0;

            while(i < n) {
                int j = i;

                while(j < n && s.charAt(j) == s.charAt(i)) {
                    j++;
                }

                int len = j - i;

                if(len > 1) {
                    deletions += (len - 1);
                    ways = (ways * len) % MOD;
                }

                i = j;
            }

            ways = (ways * fact(deletions)) % MOD;

            System.out.println(deletions + " " + ways);
        }
    }
}
