import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int total = n * k;
            long arr[] = new long[total];
            for(int i = 0; i < total; i++){
                arr[i] = sc.nextLong();
            }
            
            int m = (n + 1) / 2;
            int gap = n - m;
            
            long sum = 0;
            int index = total - gap - 1;
            
            for(int i = 0; i < k; i++){
                sum += arr[index];
                index -= (gap + 1);
            }
            
            System.out.println(sum);
        }
    }
}
