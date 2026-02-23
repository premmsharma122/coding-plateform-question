class Solution {
    public void help(int n, List<String> arr, String cur) {
        if (cur.length() == n) {
            arr.add(cur);
            return;
        }
        help(n, arr, cur + "0");
        help(n, arr, cur + "1");
    }
    public boolean hasAllCodes(String s, int k) {
        ArrayList<String> arr = new ArrayList<>();
        help(k, arr, "");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i + k <= s.length(); i++) {
            set.add(s.substring(i, i + k));
        }
        for (String a : arr) {
            if (!set.contains(a)) return false;
        }

        return true;
    }
}