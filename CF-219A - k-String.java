import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        String str = s.next();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char a : str.toCharArray()){
            hm.put(a,hm.getOrDefault(a,0)+1);
            
        }
        boolean f= false;
        for(char a : hm.keySet()){
            int fr = hm.get(a);
            if(fr % k != 0){ 
                f= true;
                break;
            }
        }
        if(f) {
            System.out.println(-1);
            
        }
        StringBuilder sub = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        if(!f){
           for (char ch : hm.keySet()) {
                int countInPart = hm.get(ch) / k;
                for (int i = 0; i < countInPart; i++) {
                    sub.append(ch);
                }
            }

           
           while(k-->0){
               sb.append(sub);
           }
        }
        System.out.println(sb.toString());
    }
}
