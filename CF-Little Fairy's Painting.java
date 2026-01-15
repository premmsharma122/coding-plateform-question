import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        while(t-->0){
            int n =sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            HashSet<Integer> hs = new HashSet<>();
            for(int a : arr){
                hs.add(a);
            }
            int k  = hs.size();
            if(hs.contains(k)) System.out.println(k);
            else{
                int c=k;
                while(true){
                    c++;
                    if(hs.contains(k)) {
                        System.out.println(c);
                        break;
                    }
                }
            }
        }
    }
}
