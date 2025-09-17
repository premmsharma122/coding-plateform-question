import java.util.*;

class Solution {
    public class Pair {
        int diff;
        int val;
        Pair(int diff, int val) {
            this.diff = diff;
            this.val = val;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.diff != b.diff) return a.diff - b.diff;
            return a.val - b.val;
        });

        for (int num : arr) {
            pq.add(new Pair(Math.abs(num - x), num));
        }

        List<Integer> res = new ArrayList<>();
        while (k-- > 0) res.add(pq.poll().val);

        Collections.sort(res);
        return res;
    }
}
