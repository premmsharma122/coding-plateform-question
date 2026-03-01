import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            String s= sc.next();
            int c=0;
            int pr[] = new int[n];
            int sf[] = new int[n];
            boolean sen[] = new boolean[26];
            for(int i=0; i<n; i++){
                int idx=s.charAt(i)-'a';
                if(!sen[idx]){
                    sen[idx]=true;
                    c++;
                }
                pr[i]=c;
            }
            Arrays.fill(sen,false);
            c=0;
            for(int i=n-1; i>=0; i--){
                int idx=s.charAt(i)-'a';
                if(!sen[idx]){
                    sen[idx]=true;
                    c++;
                }
                sf[i]=c;
            }
            int m = Integer.MIN_VALUE;
            for(int i=1; i<n; i++){
                m = Math.max(m, pr[i-1]+sf[i]);
            }
            System.out.println(m);
        }
    }
}
