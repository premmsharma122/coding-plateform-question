class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                found = true;
                int forwardDistance = Math.abs(i - startIndex);
                int backwardDistance = n - forwardDistance;
                int distance = Math.min(forwardDistance, backwardDistance);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return found ? minDistance : -1;
    }
}