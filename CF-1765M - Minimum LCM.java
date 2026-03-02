import java.util.*;
 
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while(t-- > 0){
            long n = sc.nextLong();
 
            long smallestDiv = n;
 
            for(long i=2; i*i<=n; i++){
                if(n%i==0){
                    smallestDiv = i;
                    break;
                }
            }
 
            long a;
 
            if(smallestDiv == n){ // n is prime
                a = 1;
            }else{
                a = n / smallestDiv;
            }
 
            long b = n - a;
 
            System.out.println(a+" "+b);
        }
    }
}
