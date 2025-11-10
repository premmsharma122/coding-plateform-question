class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int x : nums) {
            if (x == 0) {
                // Zero splits segments — reset stack
                while (!stack.isEmpty()) stack.pop();
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > x) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < x) {
                stack.push(x);
                ans++;
            }
            
        }

        return ans;
    }
}
