import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t  =sc.nextInt();

        while(t-->0){

            int n =sc.nextInt();
            int q = sc.nextInt();

            int arr[] = new int[n];

            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            int minX = 31;

            for(int i=0;i<q;i++){

                int x = sc.nextInt();

                if(x < minX){

                    int cur = 1<<x;
                    int add = 1<<(x-1);

                    for(int j=0;j<n;j++){

                        if(arr[j] % cur == 0){
                            arr[j]+=add;
                        }

                    }

                    minX = x;
                }
            }

            for(int v : arr){
                System.out.print(v+" ");
            }

            System.out.println();
        }
    }
}
