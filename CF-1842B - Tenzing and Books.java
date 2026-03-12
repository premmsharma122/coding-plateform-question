import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){

            int n = sc.nextInt();
            int x = sc.nextInt();

            List<Integer>[] pr = new ArrayList[3];

            for(int i=0;i<3;i++){
                pr[i] = new ArrayList<>();
                int s = 0;
                pr[i].add(s);

                for(int j=0;j<n;j++){
                    int a = sc.nextInt();

                    if((s | a) != s){
                        s |= a;
                        pr[i].add(s);
                    }
                }
            }

            HashSet<Integer> set = new HashSet<>();

            for(int a : pr[0]){
                for(int b : pr[1]){
                    set.add(a | b);
                }
            }

            boolean ans = false;

            outer:
            for(int v : set){
                for(int c : pr[2]){
                    if((v | c) == x){
                        ans = true;
                        break outer;
                    }
                }
            }

            System.out.println(ans ? "Yes" : "No");
        }
    }
}
