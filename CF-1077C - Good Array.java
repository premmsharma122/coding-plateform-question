import java.util.*;
import java.lang.*;
import java.io.*;

public class codeChef {
    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        long s = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            s += arr[i];
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            long nsum = s - arr[i];

            if (nsum % 2 != 0) continue;

            long need = nsum / 2;

            hm.put(arr[i], hm.get(arr[i]) - 1);

            if (need >= Integer.MIN_VALUE &&
                need <= Integer.MAX_VALUE &&
                hm.getOrDefault((int) need, 0) > 0) {

                ans.add(i + 1);
            }

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }

        System.out.println(ans.size());

        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}
