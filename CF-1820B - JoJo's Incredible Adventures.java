import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int  T =sc.nextInt();
        while(T-->0){
            String s =sc.next();
            int n =s.length();
            String t = s+s;
            int cur=0, m =0;
            for(int i=0; i<t.length(); i++){
                if(t.charAt(i)=='1'){
                    cur++;
                    m = Math.max(cur,m);
                }else{
                    cur=0;
                }
            }
            
            m = Math.min(n,m);
            if(m>=n){
                System.out.println((long)n*n);
            }else{
                long w = (m+1)/2;
                long ans =  w * (m-w+1);
                System.out.println(ans);
            }
            
            
        }
    }
}
