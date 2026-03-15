import java.util.*;
 
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0){
        int n=sc.nextInt();
        long minabs=Long.MAX_VALUE;
        long sum=0;
        int ng=0;
        for(int i=0;i<n;i++){
            int a =sc.nextInt();
            if(a<0) ng++;
            long cur = Math.abs(a);
            sum+=cur;
            minabs = Math.min(cur,minabs);
            
        }
        if(ng%2==0) {
            System.out.println(sum);
            
        }else{
            System.out.println(sum-2*minabs);
        }
    }
        
    
    }
}
