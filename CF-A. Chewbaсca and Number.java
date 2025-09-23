import java.util.*;
public class Main{ public static void main(String args[]){
    Scanner s = new Scanner(System.in);
    String user =s.next();
    StringBuilder sb = new StringBuilder(user);
    for(int i=0; i<user.length(); i++){
        char c = user.charAt(i);
        int d =c-'0';
        int n = 9-d;
        if(i==0 && n==0) continue;
        if(n<d){
            sb.setCharAt(i, (char)(n + '0'));
        }
    }
    String str = sb.toString();
    System.out.println(Long.parseLong(str));
    }
}
