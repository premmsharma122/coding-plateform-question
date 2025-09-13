import java.util.*;

public class Solution {
    public int[] slidingMaximum(final int[] A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0, j = 0;
        while (j < A.length) {
            
            while (!dq.isEmpty() && A[dq.peekLast()] <= A[j]) {
                dq.pollLast();
            }

            
            dq.addLast(j);

            
            if (dq.peekFirst() <= j - B) {
                dq.pollFirst();
            }

        
            if (j - i + 1 >= B) {
                arr.add(A[dq.peekFirst()]);
                i++;
            }

            j++;
        }

        
        int[] res = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            res[k] = arr.get(k);
        }
        return res;
    }
}
