import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ts =sc.nextInt();
        while(ts-->0){
            String s = sc.next();
            int one=0,zero=0,t=0;
            for(char a : s.toCharArray()){
                if(a=='1') one++;
                else zero++;
            }
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='1' && zero>0){
                    zero--;
                    t++;
                }else if(s.charAt(i)=='0' && one>0){
                    one--;
                    t++;
                }else break;
            }
            System.out.println(s.length()-t);
        }
    }
}
