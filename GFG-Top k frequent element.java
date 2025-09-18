import java.util.*;

class Solution {
    class Pair {
        int n;
        int f;
        Pair(int n, int f) {
            this.n = n;
            this.f = f;
        }
    }

    public ArrayList<Integer> topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.f == b.f) {
                return a.n - b.n;
            }
            return a.f - b.f;
        });

        for (int num : hm.keySet()) {
            pq.add(new Pair(num, hm.get(num)));
            if (pq.size() > k) pq.poll();
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().n);
        }
        Collections.reverse(result);
        return result;
    }
}
