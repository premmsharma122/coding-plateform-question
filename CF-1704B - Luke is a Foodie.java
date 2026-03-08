import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();

            int ans = 0;

            long L = Long.MIN_VALUE;
            long R = Long.MAX_VALUE;

            for(int i = 0; i < n; i++){
                long a = sc.nextLong();

                long l = a - x;
                long r = a + x;

                L = Math.max(L, l);
                R = Math.min(R, r);

                if(L > R){
                    ans++;
                    L = l;
                    R = r;
                }
            }

            System.out.println(ans);
        }
    }
}
