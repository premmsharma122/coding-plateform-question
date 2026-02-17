import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) {
            String s = sc.next();
            
            int n = s.length();
            
            if(n == 1) {
                System.out.println(s);
                continue;
            }
            
            char first = s.charAt(0);
            char last = s.charAt(n - 1);
            
            
            if(first == last) {
                System.out.println(s);
            } 
            else {
                
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(n - 1, first);
                System.out.println(sb.toString());
            }
        }
        
        sc.close();
    }
}
