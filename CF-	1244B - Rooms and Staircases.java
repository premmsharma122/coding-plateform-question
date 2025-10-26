import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){
            int n = s.nextInt();
            String st = s.next();
            
            if(st.contains("1")){
                int first = st.indexOf("1");
                int last = st.lastIndexOf("1");
                int maxRooms = Math.max((last + 1) * 2, (n - first) * 2);
                System.out.println(maxRooms);
            } else {
                System.out.println(n);
            }
        }
    }
}
