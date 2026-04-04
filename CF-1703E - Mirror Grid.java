import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            char g[][] = new char[n][n];
            for(int i=0; i<n; i++){
                g[i]= sc.next().toCharArray();
                
            }
            int ans =0;
            for(int i=0; i<n/2; i++){
                for(int j=0; j<(n+1)/2; j++){
                    int one =0;
                    if(g[i][j]=='1')one++;
                    if(g[j][n-1-i]=='1') one++;
                    if(g[n-1-j][i]=='1') one++;
                    if(g[n-1-i][n-1-j]=='1') one++;
                    
                    ans += Math.min(one,4-one);
                    
                }
            }
            System.out.println(ans);
        }
    }
}
