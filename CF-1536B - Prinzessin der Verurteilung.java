import java.util.*;
 
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
 
            boolean foundAnswer = false;
 
        
            for (char ch = 'a'; ch <= 'z'; ch++) {
                boolean found = false;
 
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == ch) {
                        found = true;
                        break;
                    }
                }
 
                if (!found) {
                    System.out.println(ch);
                    foundAnswer = true;
                    break;
                }
            }
 
            if (foundAnswer) continue;
 
        
            for (char ch1 = 'a'; ch1 <= 'z' && !foundAnswer; ch1++) {
                for (char ch2 = 'a'; ch2 <= 'z' && !foundAnswer; ch2++) {
 
                    String str = "" + ch1 + ch2;
                    boolean found = false;
 
                    for (int i = 0; i + 1 < s.length(); i++) {
                        if (s.substring(i, i + 2).equals(str)) {
                            found = true;
                            break;
                        }
                    }
 
                    if (!found) {
                        System.out.println(str);
                        foundAnswer = true;
                        break;
                    }
                }
            }
 
            if (foundAnswer) continue;
 
            
            for (char ch1 = 'a'; ch1 <= 'z' && !foundAnswer; ch1++) {
                for (char ch2 = 'a'; ch2 <= 'z' && !foundAnswer; ch2++) {
                    for (char ch3 = 'a'; ch3 <= 'z' && !foundAnswer; ch3++) {
 
                        String str = "" + ch1 + ch2 + ch3;
                        boolean found = false;
 
                        for (int i = 0; i + 2 < s.length(); i++) {
                            if (s.substring(i, i + 3).equals(str)) {
                                found = true;
                                break;
                            }
                        }
 
                        if (!found) {
                            System.out.println(str);
                            foundAnswer = true;
                            break;
                        }
                    }
                }
            }
        }
    }
}
