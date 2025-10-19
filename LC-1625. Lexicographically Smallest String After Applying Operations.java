public class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(s);
        vis.add(s);

        String ans = s;
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.compareTo(ans) < 0) {
                ans = curr;
            }
            char[] arr = curr.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
            }
            String addStr = new String(arr);

            if (!vis.contains(addStr)) {
                vis.add(addStr);
                q.add(addStr);
            }
            String rotStr = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
            if (!vis.contains(rotStr)) {
                vis.add(rotStr);
                q.add(rotStr);
            }
        }
        return ans;
    }
}
