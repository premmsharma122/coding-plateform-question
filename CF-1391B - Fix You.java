import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){
            int n = s.nextInt();
            int m = s.nextInt();
            int cn = 0;
            char ch[][] = new char[n][m];
            
            for(int i = 0; i < n; i++){
                String row = s.next();
                for(int j = 0; j < m; j++){
                    ch[i][j] = row.charAt(j);
                }
            }

            
            for(int j = 0; j < m - 1; j++){
                if(ch[n-1][j] == 'D') cn++;
            }

            
            for(int i = 0; i < n - 1; i++){
                if(ch[i][m-1] == 'R') cn++;
            }

            System.out.println(cn);
        }
    }
}
