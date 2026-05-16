import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
    static int r, w;
    public static void dfs(int n, int c, List<List<Integer>> adj, int vis[]){
        vis[n]++;
        if(c==1){
            r++;
        }else w++;
       for(int ng : adj.get(n)){
           if(vis[ng]==0){
               dfs(ng,1-c,adj,vis);
           }
       }
    }
    	public static void main (String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<n-1; i++){
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[] = new int[n];
        dfs(0,0,adj,vis);
        
        System.out.println(1L*r*w-(n-1));
        
    }
}
