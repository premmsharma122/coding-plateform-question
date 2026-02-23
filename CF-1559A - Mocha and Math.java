import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            
            int result = sc.nextInt(); // first element
            
            for(int i = 1; i < n; i++){
                result &= sc.nextInt();
            }
            
            System.out.println(result);
        }
    }
}
