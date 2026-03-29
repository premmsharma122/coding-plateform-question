import java.util.*;
public class Main{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
            }
            long ans=0;
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i=0;i<n; i++){
                int key = arr[i]-i;
                if(hm.containsKey(key)){
                    ans+=hm.get(key);
                }
                hm.put(key,hm.getOrDefault(key,0)+1);
            }
            System.out.println(ans);
        }
    }
}
