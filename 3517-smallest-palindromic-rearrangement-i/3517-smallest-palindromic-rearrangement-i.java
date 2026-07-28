class Solution {
    public String smallestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        char[] str = s.toCharArray();
        Arrays.sort(str);

        char[] res = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;

        HashSet<Character> used = new HashSet<>();

        for (char c : str) {
            if (used.contains(c)) continue;
            used.add(c);

            int freq = hm.get(c);

            while (freq >= 2) {
                res[left++] = c;
                res[right--] = c;
                freq -= 2;
            }

            if (freq == 1) {
                res[s.length() / 2] = c;
            }
        }

        return new String(res);
    }
}