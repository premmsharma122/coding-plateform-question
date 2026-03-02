import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            char c = sc.next().charAt(0);
            String s = sc.next();

            if(c=='g'){
                System.out.println(0);
                continue;
            }

            String str = s + s;
            int len = str.length();

            int nextG = -1;
            int ans = 0;

            int[] nextGreen = new int[len];

            for(int i=len-1;i>=0;i--){
                if(str.charAt(i)=='g') nextG=i;
                nextGreen[i]=nextG;
            }

            for(int i=0;i<n;i++){
                if(str.charAt(i)==c){
                    ans=Math.max(ans,nextGreen[i]-i);
                }
            }

            System.out.println(ans);
        }
    }
}
