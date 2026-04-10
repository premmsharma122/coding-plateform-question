import java.util.*;
class Codechef{
    public static ArrayList<Integer>[] tree;
    public static String s;
    public static int ans;
    public static int[] dfs(int node){
        int w =0, b=0;
        for(int n : tree[node]){
            int res[] = dfs(n);
            w+=res[0];
            b+=res[1];
        }
        if(s.charAt(node-1)=='W') w++;
        else b++;
        if(w==b) ans++;
        return new int[]{w,b};
    }
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int n  = sc.nextInt();
            tree = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                tree[i] = new ArrayList<>();
            }
            ans=0;
            for(int i=2; i<=n; i++){
                int p = sc.nextInt();
                tree[p].add(i);
            }
            s = sc.next();
            dfs(1);
            System.out.println(ans);
            
        }
        
    }
    
}
