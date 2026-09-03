class Solution {
    public boolean uniformArray(int[] nums) {
        boolean allOdd = true;
        boolean allEven = true;

        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int a : nums) {
            if (a % 2 == 0) {
                allOdd = false;
                minEven = Math.min(minEven, a);
            } else {
                allEven = false;
                minOdd = Math.min(minOdd, a);
            }
        }

        
        if (allOdd || allEven) {
            return true;
        }
        return minEven < minOdd ? false : true;
    }
}
