import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int s[] = new int[n];
            int p[] = new int[n];

            for(int i=0;i<n;i++) s[i] = sc.nextInt();

            boolean possible = true;

            int i = 0;
            while(i < n){
                int j = i;

                while(j < n && s[j] == s[i]) j++;

                if(j - i == 1){
                    possible = false;
                    break;
                }

                for(int k=i;k<j-1;k++){
                    p[k] = k+2;
                }
                p[j-1] = i+1;

                i = j;
            }

            if(!possible){
                System.out.println(-1);
            }else{
                for(int x : p) System.out.print(x+" ");
                System.out.println();
            }
        }
    }
}
