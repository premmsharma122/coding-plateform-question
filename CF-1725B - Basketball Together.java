import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int d= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] =sc.nextInt();
        }
        Arrays.sort(arr);
        int l=-1,r=n-1;
        int team=0, size=1;
        while(l<r){
            if((arr[r]*size)<=d && l<r){
                size++;
                l++;
            }else{
                team++;
                r--;
                size=1;
            }
        }
        System.out.println(team);
        
    }
}
