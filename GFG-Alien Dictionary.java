import java.util.*;

class Solution {
    public String findOrder(String[] words) {
        int n = words.length;

        // Step 1: collect all unique letters
        Set<Character> unique = new HashSet<>();
        for (String w : words) {
            for (char c : w.toCharArray()) unique.add(c);
        }
        int k = unique.size();

        // Step 2: build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    found = true;
                    break;
                }
            }
            if (!found && s1.length() > s2.length()) return "";
        }

        // Step 3: Kahn’s Algorithm (BFS Topo sort)
        int[] indeg = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int it : adj.get(i)) indeg[it]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (char c : unique) {
            if (indeg[c - 'a'] == 0) q.add(c - 'a');
        }

        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.append((char) (node + 'a'));
            for (int it : adj.get(node)) {
                indeg[it]--;
                if (indeg[it] == 0) q.add(it);
            }
        }

        // Step 4: If topo sort doesn’t include all unique letters → invalid
        if (ans.length() != unique.size()) return "";

        return ans.toString();
    }
}
