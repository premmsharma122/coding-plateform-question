class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> numSet = new HashSet<>();
        for (String num : nums) {
            numSet.add(num);
        }
        return help(n, "", numSet);
    }

    private String help(int n, String str, HashSet<String> numSet) {
        if (str.length() == n) {
            return numSet.contains(str) ? null : str;
        }

        String result = help(n, str + "0", numSet);
        if (result != null) return result;

        return help(n, str + "1", numSet);
    }
}