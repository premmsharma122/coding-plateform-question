import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sc.nextLine();

        while (t-- > 0) {
            String s = sc.nextLine();
            String tstr = sc.nextLine();

            int cnt[] = new int[26];
            for (char a : tstr.toCharArray()) {
                cnt[a - 'a']++;
            }

            int nedS[] = new int[26];
            for (char c : s.toCharArray()) {
                nedS[c - 'a']++;
            }

            boolean p = true;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] < nedS[i]) {
                    p = false;
                    break;
                }
            }

            if (!p) {
                sb.append("Impossible\n");
                continue;
            }

            StringBuilder ans = new StringBuilder();
            int sidx = 0;
            int n = tstr.length();
            int m = s.length();

            int rems[] = new int[26];
            for (char a : s.toCharArray()) {
                rems[a - 'a']++;
            }

            for (int i = 0; i < n; i++) {
                boolean placed = false;
                for (int j = 0; j < 26; j++) {
                    if (cnt[j] > 0) {
                        cnt[j]--;
                        boolean nxt = (sidx < m && j == (s.charAt(sidx) - 'a'));
                        if (nxt) {
                            rems[j]--;
                            sidx++;
                        }

                        boolean canCom = true;
                        for (int k = 0; k < 26; k++) {
                            if (cnt[k] < rems[k]) {
                                canCom = false;
                                break;
                            }
                        }

                        if (canCom) {
                            ans.append((char) (j + 'a'));
                            placed = true;
                            break;
                        } else {
                            if (nxt) {
                                sidx--;
                                rems[j]++;
                            }
                            cnt[j]++;
                        }
                    }
                }
                if (!placed) break;
            }

            sb.append(ans.toString()).append('\n');
        }

        System.out.println(sb.toString());
    }
}
