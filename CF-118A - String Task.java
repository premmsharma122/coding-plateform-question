import java.util.*;
public class Main{
    public static boolean help(char a){
        return a=='A' || a=='a' || a=='O' || a=='o' || a=='Y' || a=='y' || a=='E'||a=='e' ||a=='U'|| a=='u' || a=='I' || a=='i';
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str  = s.next();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(help(c)) continue;
            else {
                sb.append('.');
                char ne = Character.toLowerCase(c);
                sb.append(ne);
            }
        }
        System.out.println(sb.toString());
        
    }
}
