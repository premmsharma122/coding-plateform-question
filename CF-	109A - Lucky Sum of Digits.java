import java.util.*; 
public class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int best4 = -1, best7 = -1; 
        int minDigits = Integer.MAX_VALUE;

        // Loop over possible number of 7s
        for(int y = 0; y <= n/7; y++){
            int rem = n - 7*y;
            if(rem >= 0 && rem % 4 == 0){
                int x = rem / 4;
                if(x + y < minDigits){ 
                    best4 = x;
                    best7 = y;
                    minDigits = x + y;
                }
            }
        }

        if(best4 == -1){
            System.out.println(-1); 
        } else {
            StringBuilder sb = new StringBuilder();
            while(best4-- > 0) sb.append("4");
            while(best7-- > 0) sb.append("7");
            System.out.println(sb.toString());
        }
    }
}
