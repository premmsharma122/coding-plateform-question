import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int[] c = new int[n];
            
            for(int i = 0; i < n; i++){
                c[i] = sc.nextInt();
            }
            
            Arrays.sort(c);
            
            if(c[0] != 1){
                System.out.println("NO");
                continue;
            }
            
            long sum = 1;
            boolean ok = true;
            
            for(int i = 1; i < n; i++){
                if(c[i] > sum){
                    ok = false;
                    break;
                }
                sum += c[i];
            }
            
            System.out.println(ok ? "YES" : "NO");
        }
    }
}
