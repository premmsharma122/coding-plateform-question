import java.util.*;
public class Main{
    
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        
        int n =s.nextInt();
        int m =s.nextInt();
        int tm=0;
        int two = (int)Math.ceil(n/2.0);
        
        if(two%m==0) {
            System.out.println(two);
            
        }else{
            while(two <=n){
               if(two % m==0){
                   System.out.println(two);
                   return;
               }else{
                   two++;
               }
            }
            
            System.out.println(-1);
            
        }
    }
}
