class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            hm.put(s.charAt(right), hm.getOrDefault(s.charAt(right), 0) + 1);

            while (hm.get(s.charAt(right))>2) {
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1); // -1
                if (hm.get(s.charAt(left)) == 0) { 
                    hm.remove(s.charAt(left));
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
