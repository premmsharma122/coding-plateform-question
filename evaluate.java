class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashSet<String> hs = new HashSet<>();
        HashMap<String, String> hm = new HashMap<>();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                StringBuilder sb = new StringBuilder();
                i++;

                while (i < s.length() && s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }

                hs.add(sb.toString());
            }
            i++;
        }

        for (int k = 0; k < knowledge.size(); k++) {
            String ky = knowledge.get(k).get(0);

            if (hs.contains(ky)) {
                hm.put(ky, knowledge.get(k).get(1));
            }
        }

        int j = 0;
        StringBuilder ans = new StringBuilder();

        while (j < s.length()) {
            if (s.charAt(j) == '(') {
                j++;
                StringBuilder sb = new StringBuilder();

                while (j < s.length() && s.charAt(j) != ')') {
                    sb.append(s.charAt(j));
                    j++;
                }

                j++;
                ans.append(hm.getOrDefault(sb.toString(), "?"));
            } else {
                ans.append(s.charAt(j));
                j++;
            }
        }

        return ans.toString();
    }
}
