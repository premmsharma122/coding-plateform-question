class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                len[i + 1] = len[i] + 1;
            } else if (c == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (c == '#') {
                len[i + 1] = len[i] * 2;
            } else { // %
                len[i + 1] = len[i];
            }
        }

        if (k >= len[n]) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                if (k == len[i]) return c;
            }
            else if (c == '#') {
                long prev = len[i];
                if (k >= prev) {
                    k -= prev;
                }
            }
            else if (c == '%') {
                long prev = len[i];
                k = prev - 1 - k;
            }
            else { // '*'
                long prev = len[i];

                if (prev == 0) continue;

                if (k == prev - 1) {
                    return '.';
                }
            }
        }

        return '.';
    }
}