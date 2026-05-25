class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        q.offer(0);
        visited[0] = true;
        int farthest = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == n - 1) return true;

            int start = Math.max(cur + minJump, farthest + 1);
            int end = Math.min(cur + maxJump, n - 1);

            for(int i = start; i <= end; i++) {

                if(s.charAt(i) == '0' && !visited[i]) {

                    visited[i] = true;
                    q.offer(i);
                }
            }

            farthest = end;
        }
        return false;
    }
}